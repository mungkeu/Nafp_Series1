<%@page import="kr.web.util.MyUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyUtil my = new MyUtil();
	int sum = my.hap();
	/*
	   이런식으로 클래스를 따로 분리해서 사용해야 편하다.
	   그리고 분리를 위해서는 classes에 .class 파일이 모아져야하는데 이 도한
	   설정을 해줘야 한다.
	   프로젝트 우클릭 -> Build Path -> Configure Build Path -> Source -> Brodwse... 클릭해서 설정해준다.
	 */
%>
<!-- 이 위로 처리 즉 비즈니스 로직 -->
<!-- 이 아래로 프리젠테이션 로직 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
 <td>1~100까지의 총합</td>
 <td><%=sum%></td>
</tr>
</table>
</body>
</html>
<!-- 
	Model 1 방식
	JSP + Model
	 V  +  M  방식
 -->