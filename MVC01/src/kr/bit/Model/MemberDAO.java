package kr.bit.Model;
// JDBC -> myBatis, JPA
import java.sql.*;
public class MemberDAO {
	private Connection conn;		// 데이터베이스 연결 개체
	private PreparedStatement ps;	// sql을 전송할수 있는 개체중에서 PreparedStatement가 필요
	private ResultSet rs;			// 데이터베이스의 값을 가지고와서 저장해놓을 수 있는 개체
}
