<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- JSP 지시자 -->
    
<%!
	/*함수도 사용 가능*/
	public int hap(int s, int e){
		int sum=0;
		for(int i=s; i<=e; i++)
		{
			sum+=i;
		}
		return sum;
	}
%>

<%
	int sum=0;
	for(int i=1; i<=10; i++)
	{
		sum+=i;
	}
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
	<td>1~10까지의 총합=</td>
	<td><%=sum %></td>
</tr>
<tr>
	<td>55~350까지의 총합=</td>
	<td><%=hap(55,350)%></td>
</tr>
</table>
</body>
</html>