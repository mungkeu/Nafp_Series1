<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.Model.*" %>
<%
	Mycalc c = new Mycalc();
	int v = c.hap(1,300);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>1~300까지이 합:</td>
		<td><%=v %></td>
	</tr>
</table>
</body>
</html>