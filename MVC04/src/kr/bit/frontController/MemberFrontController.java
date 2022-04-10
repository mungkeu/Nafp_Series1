package kr.bit.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import kr.bit.Model.*;
import kr.bit.controller.*;
import kr.bit.controller.MemberListController;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// insert에서 넘어오는 한글이 깨질까봐
		request.setCharacterEncoding("utf-8");

		// 클라이언트가 어떤 요청을 했는지 파악하기
		// request에 저장되어 있으므로 request로 파악한다.
		String url = request.getRequestURI();
		System.out.println(url); // /MVC/memberInert.do

		String ctx = request.getContextPath();
		System.out.println(ctx); // /MVC04

		// 실제로 요청한 명령이 무엇인지
		String command = url.substring(ctx.length()); // /memberInert.do
		System.out.println(command);

		Controller controller = null;
		String nextPage = null;

		// 분기작업
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage=controller.requestHandler(request, response);

		// forward, redirect
		if (nextPage != null) {
			if (nextPage.indexOf("redirect:") != -1) {
				// redirect:/MVC04/memberList.do
				response.sendRedirect(nextPage.split(":")[1]); // redirect

			} else {                                              // 경로
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeView(nextPage));
				rd.forward(request, response);
			}
		}

	}
}