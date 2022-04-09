package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.Model.MemberDAO;
import kr.bit.Model.MemberVO;

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 인터넷으로 넘어올 때 1byte씩 넘어오므로 한글데이터 인코딩. 문자하나를 2바이트로 처리.
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
		vo.setName(name);        //  <= setter를 이용하는게 생성자보다 좀 더 범용적.
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		//System.out.println(vo); // vo.toString();
		
		// Model과 연동
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);
		//PrintWriter out = response.getWriter();
		if(cnt>0) {
			// 가입성공
			//out.println("insert success");
			// 응답을 /MVC01/memberList.do로 바꾸어준다. 
			// 서버가 응답을 다른페이지로 돌리는 기술 (리다이렉트 기술)
			// 즉 내가 요청하지 않아도 서버에서 알아서 돌린다. 
			response.sendRedirect("/MVC03/memberList.do");
		}else {
			// 가입실패 -> 예외객체를 만들어서 WAS에게 던지자.
			throw new ServletException("not insert");	
		}
	}

}
