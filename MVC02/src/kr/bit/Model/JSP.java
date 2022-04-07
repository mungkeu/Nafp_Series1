/*
 * JSP 구성요소 
 *
 * 스크립트적인 요소 = 프로그래밍적인 요소
 * 
 * 지시자는 3가지가 있따.
 * <%@page     %> 지시자 : page 지시자
 * <%@include  %> 지시자 : include 지시자
 * <%@taglib   %> 지시자 : taglib 지시자 
 * 
 * <%  %> 스크립트릿
 * <%= %> 출력식
 * <%! %> 선언문
 * <%-- SJP 주석 --%>
 * 
 * JSP는 곧 Servlet이다.
 *     										요청				    Servlet으로 변환
 * http://localhost:8081/MVC02/test01.jsp  -------> test01.jsp ----------------> test01_jsp.java -> 자바파일은 웹에서 서블릿으로 변환.
 *                                          								 	 (servlet)       -> 컴파일 됨-> .class 생성
 *                                         <------------------------------------ test01_ksp.class-> .class 파일이 되어 실행
 *                                                 결과 페이지 응답.
 * 서블릿이 변환된 파일이 저장되어 있는 장소.
 * C:\eGovFrame-3.10.0\workspace.edu\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\MVC02\org\apache\jsp
 * 
 * JSP의 내장객체(이미 만들어진 객체)
 * - request, response
 * - session, out, config, application, page, pageContext
 *
 */