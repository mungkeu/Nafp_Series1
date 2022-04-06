package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/h.do")
public class HelloStart extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 현재 서블릿은 3가지 역할을 다 하고 있다.
		// 1. 클라이언트의 요청을 받는 작업(파라메터로 수집)		  -> Controller(Servlet)
		// 2. 처리하는 작업(비즈니스 로직) -> Model           -> Model(Java class)
		int sum=0;
		for(int i=1; i<=100; i++)
		{
			sum+=i;
		}
		// 3. 요청한 클라이언트에게 응답하는 작업 -> 프리젠테이션 로직 -> View(JSP)
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(sum);
		out.println("</body>");
		out.println("</html>");
	}

}

/*
 * MVC  <--- client
 * 클라이언트의 요청을 가장먼저 받는 것이 Controller이다. 
 * 
 * 우선 위의 구조에서 Sevlet과 Model로 회원 관리 만들기(일단, Model만이라도 빼내자)
 */

