# JAVA, 전자정부 프레임워크 3.10.0
Used IDE : eGovframe.edu</br>
강의 : 인프런, [NarP Series]MVC 프레임워크는 내손에[나프1탄]

</br>

---

</br>

### **JAVA MVC**

**1. 웹 개발환경(eGovFrame-3.1.0) 구성하기**
* _src.kr.web_
  - _Util_
    - [MyUtil.java](https://github.com/mungkeu/Nafp_Series1/blob/main/Web/src/kr/web/util/MyUtil.java) - 비즈니스 로직 분리 class Test
  - _controller_
    - [HelloServlet.java](https://github.com/mungkeu/Nafp_Series1/blob/main/Web/src/kr/web/controller/HelloServlet.java) - Servlet골격, mapping, HttpServletRequest, HttpServletResponse
  - _db_
    - [member.sql](https://github.com/mungkeu/Nafp_Series1/blob/main/Web/src/kr/web/db/member.sql) - 회원 DB 테이블 생성
* _webapp_
   - [index.html](https://github.com/mungkeu/Nafp_Series1/blob/main/Web/webapp/index.html) - 정적 페이지 테스티 및 톰켓 서버 연동 방법
   - [mysqldb.html](https://github.com/mungkeu/Nafp_Series1/blob/main/Web/webapp/mysqldb.html) - 전자정부 프레임워크 다운 및 MySql 연동 방법
   - [sum.jsp](https://github.com/mungkeu/Nafp_Series1/blob/main/Web/webapp/sum.jsp) - JSP 비즈니스로직 분리 및 생성한 classes 폴더 연동 방법
   - [time.jsp](https://github.com/mungkeu/Nafp_Series1/blob/main/Web/webapp/time.jsp) - 서블릿 사용을 위한 servlet-api.jar 파일을 연동 방법
  - _사용중인 lib_
    - [lib](https://github.com/mungkeu/Nafp_Series1/tree/main/Web/webapp/WEB-INF/lib)
  
</br>

---

</br>

**2. MVC01 버전(Servlet과 Model만을 이용한 회원관리 만들기**
* _src.kr.bit_
  - _Model_
    - [Mycalc.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/Model/Mycalc.java) - Calc 서블릿의 비즈니스 로직을 분리
    - [MemberDAO.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/Model/MemberDAO.java) - 회원 JDBC를 위한 클래스
    - [MemberVO.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/Model/MemberVO.java) - 회원 VO 클래스
  - _controller_   
    - [HelloStart.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/controller/HelloStart.java) - 서블릿 테스트
    - [CalcController.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/controller/CalcController.java) - Request, Response의 전송방식 및 Post와 Get 전송 방식과 쿼리스트링
  - _db_
    - [member.sql](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/db/member.sql) - 회원 DB 테이블 생성
* _WebContent_
  - _member_
    - [memberRegister.html](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/WebContent/member/memberRegister.html) - 회원 가입 UI 페이지
  - [index.html](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/WebContent/index.html)
  - [su.html](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/WebContent/su.html) - CalcController에 데이터 전송을 위한 클라이언트 UI 페이지
  - [test.jsp](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/WebContent/test.jsp)
  - [%EB%B0%B0%ED%8F%AC.html](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/WebContent/%EB%B0%B0%ED%8F%AC.html) - 배포 방법, Export, Import
