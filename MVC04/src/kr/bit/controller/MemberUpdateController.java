package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.Model.MemberDAO;
import kr.bit.Model.MemberVO;

public class MemberUpdateController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 파라메터 수집(VO)
		int num = Integer.parseInt(request.getParameter("num"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String ctx = request.getContextPath();
		MemberVO vo = new MemberVO();
		vo.setNum(num);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);

		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberUpdate(vo);
		String nextPage=null;
		if (cnt > 0) {
			nextPage = "redirect:"+ctx+"/memberList.do";
		} else {
			throw new ServletException("not insert");
		}

		return nextPage;
	}
}
