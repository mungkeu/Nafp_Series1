package kr.bit.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.Model.MemberVO;


@WebServlet("/Fc.do")
public class ForwardController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name="park";
		int age = 45;
		String email="aaa@empal.com";
		
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);

		/* 
		 * 2. forward
		 * request.setAttribute("data", data); // 객체 바인딩(request 바인딩). request라는 객체에 데이터를 연결해서 객체바인딩이라 한다.
		 * 
		 * url이 컨트롤러의 가짜이름으로 표시된다. 그 이유는 리다이렉트와 달리 뷰가 전달해준 데이터를 보낸것이기 때문에.
		 */
		
		// forward.jsp
		request.setAttribute("vo", vo); // 객체 바인딩
		RequestDispatcher rd = request.getRequestDispatcher("view/forward.jsp");
		rd.forward(request, response);
	}

}
