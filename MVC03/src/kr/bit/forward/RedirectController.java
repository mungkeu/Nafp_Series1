package kr.bit.forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rc.do")
public class RedirectController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. forward 실습
		//String data="apple";
		String name="park";
		int age = 45;
		String email="aaa@empal.com";
		
		/*
		 * View page (result.jsp)로 data를 전달하여 View page에서 출력.
		 * Controller에서 View로 페이지를 전환하는 방법
		 * 
		 * 1. redirect
		 * Redirect는 연결을 끝고 전화를 돌려주는 것이기 때문에
		 * result.jsp는 현재 이 컨트롤러의 request와 reponse를 가지고 있지 않다.
		 * response.sendRedirect("view/result.jsp");
		 * 해결 방법으로는 get방식으로 꼬리표를 붙여 데이터를 보내줄 수 있다.
		 * response.sendRedirect("view/result.jsp?data="+data);
		 *                                 
		 * 안되는 방법
		 * request.setAttribute("data", data); 데이터를 request에 저장
		 * response.sendRedirect("view/result.jsp"); redirect는 연결을 끊고 새로 연결하기 때문에 저장된 request도 날라간다.
		 * 
		 * 단, 여러개의 정보를 보낼때 곤란하다.
		 */
		response.sendRedirect("view/result.jsp?name="+name+"&age="+age+"&email="+email);
		// *                                        get방식의 query String
		
		 
	}

}
