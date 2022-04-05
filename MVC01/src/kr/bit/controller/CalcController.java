package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.Model.Mycalc;

// 서블릿은 Controller의 역할을 한다.
@WebServlet("/calc.do")
public class CalcController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1. 클라이언트에서 넘어오는 폼 파라메터 받기(파라메터 수집 : su1, su2) <-- request 객체 저장되어 있는
		//	  su1과 su2을 빼낸다
		int su1 = Integer.parseInt(request.getParameter("su1")); // 무조건 String로만 받기 때문에 Integer로 바꿔준다.
		int su2 = Integer.parseInt(request.getParameter("su2")); // <-- reqeust에는 요청정보(header,body)가 있어서 이 정보를 빼낼수도 있다.
		
		// su1~su2=?
		// 아래의 비즈니스로직을 -> Model로 분리하기.
//		int sum=0;
//		// 빼온 정보를 처리
//		for(int i=su1;i<=su2;i++)
//		{
//			sum+=i;
//		} 
		
		Mycalc mc = new Mycalc();
		int sum = mc.hap(su1, su2);
		
		// 이부분은 차후에 JSP로 분리
		PrintWriter out = response.getWriter(); // response는 header(ip, port) 정보가 있어서 클라이언트와 서버를 연결해준다
		                                        // 그 후 스트림 객체인 out을 이용해서 데이터를 전송해준다.
		
		// 응답하는 부분(프리젠테이션 로직 = View = JSP)
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>TOTAL</td>");
		out.println("<td>");
		out.println(sum);
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");		
		out.println("</body>");
		out.println("</html>");
	}


}

/*
 * ip:172.87.35.1           이동
 * port:9000               ----->
 * CLIENT---------------------------------------------------------->SERVER(톰켓)
 *                           요청										 톰켓(AWS)은 받은 데이터를 저장하기 위해서 두 가지 객체를 만든다.
 *                         요청정보(패킷)	post방식						 HttpServletRequest(요청객체)                      HttpServletResponse(응답객체)
 *                         header  		 body                        - 요청정보(header,body)를 요청객체 에 저장해 둔다.        - 전송을 위해서 응답객체도 header(ip,poer)를 저장하고 있는다.
 *                         ip:172.87.35.1    su1=1					 request 객체가 이 저장된 번지를 가지고 있다.			     response 객체가 이 저장된 번지를 가지고 있다.
 *                         port:9000         su2=100
 *                         
 * CLIENT<----------------------------------------------------------SERVER(톰켓)     
 *                           응답
 *                         total=5050         
 * 전송방식
 * 1. post방식 (http://localhost:8081/MVC01/calc.do)
 * - 패킷에 담아서 넘어가는 값을 숨겨서 보내는것이 (데이터를 패킷의 body에 저장) 
 * - 넘기는 데이터의 한계가 없다.
 * - 일반적으로 form으로 전송할 때에는 주로 post를 사용한다.
 * - 캐싱할 수 없다.(즉 전송할때마다 body의 값이 바뀌므로 유지되지 않는다.)
 * - URL의 데이터가 노출되지 않아 보안이 get방식에 비해 안전하다.
 * - 주로 <form> 으로 전송할 때 사용한다.
 * 
 * get 방식 (http://localhost:8081/MVC01/su.html?su1=1&su2=100)
 * - 서버로 전송할 때 URL뒤에 데이터를 붙여서 전송한다 (보안에 취약) 즉 URL 뒤에 노출된다. ->?su1=1&su2=100(쿼리스트링)
 * - URL창에 입력이 무한하지 않아 전송하는 데이터의 한계가 있다.
 * - get 방식은 body가 없어서 header에 모두 저장하여 전송한다.
 * - 캐싱할 수 있다.
 * - 주로 <a>링크 태그를 사용하여 전송할 때 사용한다.
 * 
 * 쿼리스트링
 * - get방식의 URL 뒤에 포함되는 데이터(변수와 값)
 * - 공백이 들어갈 수 없다.
 * ?su1=1&su2=100
 */		
