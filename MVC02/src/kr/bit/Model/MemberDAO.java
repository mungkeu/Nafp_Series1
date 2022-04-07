package kr.bit.Model;
// JDBC -> myBatis, JPA
import java.sql.*;
import java.util.ArrayList;
public class MemberDAO {
	private Connection conn;		// 데이터베이스 연결 객체
	private PreparedStatement ps;	// sql을 전송할수 있는 객체
	private ResultSet rs;			// 데이터베이스의 값을 가지고와서 저장해놓을 수 있는 객체
	//private String Driver = "com.mysql.jdbc.Driver"; 
	// 데이터베이스 연결객체 생성(Connection)
	public void getConnect() {
		String URL="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimeZone=UTC";
		String user="root";
		String password="admin12345";
		
		/*
		 * MySQL Driver Loading                  JDBC -> java.sql 
		 * 여러 DB를 유연하게 사용하기 위해서 Oracle JAVA의 API(인터페이스)를 각 벤더사에 배포해
		 * 각 벤더사들이 구현 클래스(받은 추상메서드)를 작성해서 배포 이 구현 클래스를 Driver라고 한다.
		 * 그렇기 때문에 DB와 접속방법이 다달라도 메서드는 모두 같다.
		 * 즉 자바 개발자는 인터페이스인 JDBC만 알면된다. 이는 java.sql에 있다.
		 * 사용하기 위해서 mysql-connector-java.버전.jar 파일을 lib에 넣어주자. (각 벤더에서 다운)
		 * com.mysql.jdbc.Driver 우리가 사용할 수많은 클래스중에 제일 중요한 클래스.
		 * class.forName 메서드가 해당 클래스를 찾아 로딩한다. 동적 로딩 방법(실행시점에 드라이버를 메모리에 올린다.)
		 * 있을지 없을지 모르기 때문에 예외처리가 필요하다.
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 컴파일시에는 문자열 실행해야 찾아간다.
			// 3개의 정보를 getConnection에 넣어주면 그걸 보고 mysql DB에 접속 시도를 한다.
			// 성공시 연결 정보를 넘겨준다. 타입은 Connection 
			conn = DriverManager.getConnection(URL, user, password); 
		} catch(Exception e) {
			/*
			 * 클래스 즉 jar 파일이 없으면 Class가 없다고 알려준다. ClassNotFoundException
			 * 하지만 예외가 많기 때문에 그냥 모든 예외 클래스의 부모(Exception)를 적는다
			 * e.getMessage() : 에러의 원인을 간단하게 출력합니다.
			 * e.toString() : 에러의 Exception 내용과 원인을 출력합니다.
			 * e.printStackTrace() : 에러의 발생근원지를 찾아서 단계별로 에러를 출력합니다.
			 */
			e.printStackTrace();
		}
	}
	// 회원 저장 동작
	public int memberInsert(MemberVO vo)
	{			// ?는(파라메터) 순서가있다.  1     2     3    4      5      6
		String SQL="insert into member(id, pass, name, age, email, phone) values(?,?,?,?,?,?)"; // 아직은 값이 없는 불완전 SQL
		getConnect();
		int cnt = -1;
		try {
			// SQL문장을 전송하는 객체를 생성한다.
			// 이객체를 만들때 위의 불완전한 SQL을 DB에 한번 전송을 먼저 해준다.
			// 그 이유는 SQL구문이 완전한지 미리 컴파일 하기 위해서 즉 ?를 제외하고 체크한다.
			// 뿐만 아니라 미리 컴파일하면 속도가 빠르다.
			ps= conn.prepareStatement(SQL); // 미리 컴파일 시킨다.
			
			// ps의 ?의 값을 넣어준다.
			ps.setNString(1, vo.getId());  // ps가 가지고 있는 SQL ?의 첫 번째에 vo.getId()를 넣어라.
			ps.setNString(2, vo.getPass());
			ps.setNString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setNString(5, vo.getEmail());
			ps.setNString(6, vo.getPhone());
			
			// DB에 전송(실행)해준다.
			cnt = ps.executeUpdate(); // 성공한 행의 수를 반환해준다. 성공 1, 실패 0 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally { // finally 구문은 에러 유무와 상관없이 무조건 실행.
			dbClose(); // db 커넥션 끊기.
		}
		return cnt;
	}
	
	// 회원(VO)전체 리스트(ArrayList) 가져오기
	public ArrayList<MemberVO> memberList() {
		String SQL="select * from member";
		getConnect();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>(); 
		try {
			ps=conn.prepareStatement(SQL);
			
			// DB에 변화는 없고 데이터를 가져오기만 할때는 Query를 사용.  rs->커서를 이동시킨다.
			// rs는 첫번째 컬럼명을 가르키고 있다. 여기서는 num.
			// ResultSet 에는 커서를 이동해 다음 레코드를 가리키는 next() 메서드가 있다.
			// 이 메서드는 데이터가 있으면 true를 없으면 false를 반환한다.
			rs = ps.executeQuery();
			
			while(rs.next()) {
				// MemberVO로 묶어서 ArrayList에 담는다.
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				MemberVO vo = new MemberVO(num, id, pass, name, age, email, phone); 
				list.add(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
	
	// 삭제 메서드
	public int memberDelete(int num)
	{
		String SQL = "delete from member where num=?";
		int cnt=-1;
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			cnt = ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	// 상세보기 메서드
	public MemberVO memberContent(int num)
	{
		String SQL="select * from member where num=?";
		getConnect();
		MemberVO vo = null;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setInt(1, num);
			rs=ps.executeQuery();
			if(rs.next()) {
				num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				vo = new MemberVO(num, id, pass, name, age, email, phone);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return vo;
	}
	
	// 상세정보 수정
	public int memberUpdate(MemberVO vo)
	{								//   1        2       3             4
		String SQL = "update member set age=?, email=?, phone=? where num=?";
		getConnect();
		int cnt=-1;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setInt(1, vo.getAge());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getPhone());
			ps.setInt(4, vo.getNum());
			
			cnt=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	// 데이터베이스 연결 끊기
	public void dbClose()
	{
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
