package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberRegisterController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 여기서 return하고 받은다음 forward로 하는 이유는 redirect로 하게되면 http://127.0.0.1:8081/MVC04/member/memberRegister.html로 변해
		 * 다음화면으로 갈때 http://127.0.0.1:8081/MVC04/member/ 뒤에 적혀 ../등의 작업을 해줘야해서 불편하다.
		 */
		//return "/WEB-INF/member/memberRegister.jsp";
		return "memberRegister";
	}

}
