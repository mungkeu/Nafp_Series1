package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.Model.MemberDAO;
import kr.bit.Model.MemberVO;

public class MemberListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// POJO가 해야할 일의 범위
		// 1. Model 연동
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		// 2. 객체 바인딩
		request.setAttribute("list", list);
		// member/memberList.jsp
		// 다음 페이지는
		// 3. 다음 페이지 정보(View)
		//return "/WEB-INF/member/memberList.jsp"; // 폴더 변경시 문제...
		return "memberList"; // 뷰의 이름만 리턴
		
		// prefix + 논리적이름 + subfix => 이렇게 만드는 것을 ViewResolver라고 한다. 
	}

}
