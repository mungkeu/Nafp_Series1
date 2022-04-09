<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//  Controller-->JSP
	String[] str={"사과","바나나","포도","귤","오렌지"}; 
	request.setAttribute("str",str);
%>
<%--
	c:forEach의 items에 str을 바로 쓸수 없다. el은 jstl과 사용해야 하기 때문
	단, setAttribute로 받은 값은 사용가능.
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="f" items="${str}"> <%-- var는 값과 속성을 꺼내올 수 있다. --%>
	${f}<br>
</c:forEach>
</body>
</html>