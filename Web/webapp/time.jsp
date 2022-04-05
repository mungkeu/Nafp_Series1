<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	java.util.Date d = new java.util.Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	손기명  홈페이지 방문을 환영합니다.(동적인 페이지)<br>
	지금 시간이 몇시인지? <%=d.toString() %>
</body>  
</html>


<!-- 
	서블릿을 사용하기 위해서는 servlet-api.jar 파일을 연동해줘야 한다.
	lib에 servlet-api.jar 파일을 넣어주고. 이제 이것을 톰켓이 인식하도록
	
	프로젝트 우클릭 -> Build Path -> Configure Build Path -> 
	Libraries -> Add External JARs 클릭 후 해당 jar 파일을 찾아 연결한다.
	C:\eGovFrame-3.10.0\bin\apache-tomcat-8.5.50\lib
 -->