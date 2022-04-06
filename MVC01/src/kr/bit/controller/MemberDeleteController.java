package kr.bit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.Model.MemberDAO;

@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// http://localhost:8081/MVC01/memberDelete.do?num=7 => request에 저장되어 있다.
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberDelete(num);
		
		if(cnt>0) {
			response.sendRedirect("/MVC01/memberList.do");
		}else {
			throw new ServletException("not insert");
		}
			
	}

}
