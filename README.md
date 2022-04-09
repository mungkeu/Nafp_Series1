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

**2. MVC01 버전 Servlet과 Model만을 이용한 회원관리 만들기**
* _src.kr.bit_
  - _Model_
    - [Mycalc.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/Model/Mycalc.java) - Calc 서블릿의 비즈니스 로직을 분리
    - [MemberDAO.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/Model/MemberDAO.java) - 회원 JDBC를 위한 클래스 (Java+SQL)
    - [MemberVO.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/Model/MemberVO.java) - 회원 VO 클래스
  - _controller_   
    - [HelloStart.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/controller/HelloStart.java) - 서블릿 테스트
    - [CalcController.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/controller/CalcController.java) - Request, Response의 전송방식 및 Post와 Get 전송 방식과 쿼리스트링
    - [MemberContentController.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/controller/MemberContentController.java) - 회원 정보 상세보기
    - [MemberDeleteController.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/controller/MemberDeleteController.java) - 회원 정보 삭제
    - [MemberInsertController.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/controller/MemberInsertController.java) - 회원 정보 등록
    - [MemberListController.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/controller/MemberListController.java) - 회원 정보 리스트 출력
    - [MemberUpdateController.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/controller/MemberUpdateController.java) - 회원 정보 수정
    - [MVC01_Summary.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/controller/MVC01_Summary.java) - MVC01 정리
  - _db_
    - [member.sql](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/src/kr/bit/db/member.sql) - 회원 DB 테이블 생성 및 테스트
* _WebContent_
  - _member_
    - [memberRegister.html](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/WebContent/member/memberRegister.html) - 회원 가입 UI 페이지
  - [index.html](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/WebContent/index.html)
  - [su.html](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/WebContent/su.html) - CalcController에 데이터 전송을 위한 클라이언트 UI 페이지, 컨텍스트 패스
  - [test.jsp](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/WebContent/test.jsp)
  - [%EB%B0%B0%ED%8F%AC.html](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC01/WebContent/%EB%B0%B0%ED%8F%AC.html) - 배포 방법, Export, Import
  
</br>

---

</br>

**3. MVC02 버전 JSP와 Model만을 이용한 회원관리 만들기 (모델1방식)**
* _src.kr.bit_
  - _Model_
    - [MemberDAO.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC02/src/kr/bit/Model/MemberDAO.java) - 회원 JDBC를 위한 클래스 (Java+SQL)
    - [MemberVO.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC02/src/kr/bit/Model/MemberVO.java) - 회원 VO 클래스  
    - [JSP.java](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC02/src/kr/bit/Model/JSP.java) - MVC02 정리
  - _db_
    - [member.sql](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC02/src/kr/bit/db/member.sql) - 회원 DB 테이블 생성 및 테스트
* _WebContent_
  - _member_
    - [memberRegister.html](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC02/WebContent/member/memberRegister.html) - 회원 가입 UI 페이지
    - [memberList.jsp](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC02/WebContent/member/memberList.jsp) - 회원 정보 리스트 출력
    - [memberInsert.jsp](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC02/WebContent/member/memberInsert.jsp) - 회원 정보 등록
    - [memberContent.jsp](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC02/WebContent/member/memberContent.jsp) - 회원 정보 상세보기
    - [memberDelete.jsp](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC02/WebContent/member/memberDelete.jsp) - 회원 정보 삭제
    - [memberUpdate.jsp](https://github.com/mungkeu/Nafp_Series1/blob/main/MVC02/WebContent/member/memberUpdate.jsp) - 회원 정보 수정

</br>

---

</br>

**4. MVC03 버전 Model-View-Controller를 이용한 회원관리 만들기 (모델2방식)**
* _src.kr.bit_
  - _Model_
  - _controller_
  - _db_
* _WebContent_
  - _member_
