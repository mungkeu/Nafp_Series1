package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.Model.MemberDAO;
import kr.bit.Model.MemberVO;

@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 클라이언트의 요청을 받기(memberList.do)
		// 2. 회원 전체 리스트 가져오기(Model 연동)
		MemberDAO dao = new MemberDAO(); 
		ArrayList<MemberVO> list = dao.memberList();
		
		// 3. 회원 전체 리스트를 HTML로 만들어서 응답하기
		// - 응답되는 데이터안에 한글이 있는 경우 -> 인코딩
		// - 서버가 MIME TYPE을 알려줘야 데이터 타입을 알고 한글을 인식한다.
		//System.out.println(list);
		response.setContentType("text/html;charset=utf-8"); // MIME TYPE, 스트림 생성전에 만들어야 한다.
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>");
		out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table class='table table-bordered'>");
		out.println("<tr>");
		out.println("<td>번호</td>");
		out.println("<td>아이디</td>");
		out.println("<td>비밀번호</td>");
		out.println("<td>이름</td>");
		out.println("<td>나이</td>");
		out.println("<td>이메일</td>");
		out.println("<td>전화번호</td>");
		out.println("<td>삭제</td>");
		out.println("</tr>");
		for(MemberVO vo : list) {
			out.println("<tr>");
			out.println("<td>"+vo.getNum()+"</td>");
			out.println("<td><a href='/MVC01/memberContent.do?num="+vo.getNum()+"'>"+vo.getId()+"</a></td>");
			out.println("<td>"+vo.getPass()+"</td>");
			out.println("<td>"+vo.getName()+"</td>");
			out.println("<td>"+vo.getAge()+"</td>");
			out.println("<td>"+vo.getEmail()+"</td>");
			out.println("<td>"+vo.getPhone()+"</td>");
			out.println("<td><a href='/MVC01/memberDelete.do?num="+vo.getNum()+"'>삭제</a></td>");
			out.println("</tr>");
		}
		out.println("<tr>");
		out.println("<td colspan='8' align='right'>");
		out.println("<a href='member/memberRegister.html'>회원가입</a>"); // get방식, 쿼리스트링
		out.println("</tr>");
		out.println("</table>");		
		out.println("</body>");
		out.println("</html>");
	}

}
