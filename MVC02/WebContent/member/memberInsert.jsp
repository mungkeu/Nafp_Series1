<%@page import="kr.bit.Model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		//인터넷으로 넘어올 때 1byte씩 넘어오므로 한글데이터 인코딩. 문자하나를 2바이트로 처리.
		request.setCharacterEncoding("utf-8"); 
		// 1. 파라메터수집(VO)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		// 파라메터수집(VO)
		// MemberVO vo = new MemberVO(id, pass, name, age, email, phone);
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);        
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);
		if(cnt>0) {
			// 가입성공
			response.sendRedirect("memberList.jsp");
		}else {
			// 가입실패 -> 예외객체를 만들어서 WAS에게 던지자.
			throw new ServletException("not insert");	
		}				
%>

<%-- 컨트롤러용 JSP --%>