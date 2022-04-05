package kr.web.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import kr.web.util.MyUtil;

// JavaEE의 기본프로그램인 Servlet의 골격
@WebServlet("/hs.do")
public class HelloServlet extends HttpServlet {
	//                          요청                                     응답
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// 서블릿도 톰켓이 처리하기 때문에 서비스 메서드가 구동되면서 에러가 발생하면 이 에러를 톰켓 서버에 던져서 톰켓이 처리할 수 있게 해줘야 한다.
		// 서블릿에서 일어나는 예외 : ServletException
		// 웹은 클라이언트와 서버가 보내고 받고 할때 내부적으로 입출려과 관련된 IO 방식으로 일어나기 때문에 이에 대한 예외처리도 한다. : IOException
		
		// 1~100까지의 총합 = ?
		MyUtil my = new MyUtil();
		int sum = my.hap();
		
		// 요청한 클라이언트에게 어떻게 응답할까? 
		// 1. 요청한 클라이언트의 IP와 Port번호가 필요하다. 
		// 2. 클라이언트가 서버에 요청을 할때는 기본적으로 ip와 port정보가 서버로 넘어가게 된다.
		//    즉, 서버에 요청이오면 서버는 스퀘스트와 리스폰스 객체를 만들어서 넘어온 클라이언트의 ip나 포트정보를 저장하고 서비스 메서드는
		//    이것을 가지고 처리한다.
		
		// 현재 클래스는 응답만 하면 되므로 response 객체인 resp를 이용하면 된다.
		// response의 getWriter()메서드는 요청한 클라이언트와 연결시키는 IO 하나를 만들어내는 메서드
		// PrintWriter라는 객체가 넘어온다 response가 현재 클라이언트를 식별하고 있어 getWriter와 연결된
		// 출력스트림을 하나 얻어오면 된다.
		// 즉 출력스트림은 resp가 getWriter를 이용해서 out을 하나 얻어오면 (out은 요청한 클라이언트와 연결되어 있는 하나의 빨대)
		// 이 빨대를 이용해 클라이언트에 html 코드를 내려주면 된다.
		PrintWriter out = resp.getWriter();
		out.println("<html>"); // 자바에서는 문자열이지만 브라우저에서는 html 태그로 인식한다.
		out.println("<body>");
		out.println(sum);
		out.println("</body>");
		out.println("</html>");  // <- 이런 부분이 디자이너와의 협업과 유지보수에 문제가 있어 JSP가 등장하게 된다.
		
		/*
		 * 클라이언트가 서블릿에 어떻게 요청할까?
		 * 클라이언트가 URL(경로)로 요청하지 못하는 이유
		 * 1. 보안에 취약
		 * 2. 경로가 너무 길다. http://localhost:8081/web/WEB-INF/classes/kr.Web.controller.HelloServlet
		 * 
		 * 해결: 이 긴 경로를 다른 경로로 매핑하자. servlet-mapping
		 * /WEB-INF/classes/kr.Web.controller.HelloServlet을 아래로 매핑 -> 진짜 경로
		 * /hs.do -> 서블릿의 가짜 이름
		 * 
		 * WEB-INF 아래의 web.xml을 사용해서 서블릿 매핑을 할 수 있다.
		 * - /WEB-INF/classes/까지는 톰켓서버가 이미 알고있다.
		 * 
		 * <servlet> // 여기에 클래스를 넣어준다.
		 * 		<servlet-name>HelloServlet</servlet-name> // 가짜이름과 진짜이름을 연결할 이름은 개발자 마음대로 적어줘도 되지만 통상적으로 클래스 이름을 적어준다.
         *		<servlet-class>/kr.web.controller.HelloServlet</servlet-class> // 진짜 서블릿 이름 
    	 *</servlet>
    	 *
    	 *<servlet-mappin> // 여기에 매핑할 이름을 넣어준다.
    	 *		<servlet-name>HelloServlet</servlet-name> // 서블릿 매핑이 찾아가는 이름
         *		<url-pattern>/hs.do</url-pattern> // URL 상의 가짜 서블릿 이름
    	 *</servlet-mappin>
    	 *
    	 *하지만 이렇게 할 경우 너무 귀찮고 많아진다. 방법은 없을까?
    	 *해결 : 어노테이션을 사용한다. 프로그램이 실행하기 전에 서버에 알려주는 작업들(메타데이터)
    	 *@WebServlet("/hs.do") // <-- web.xml 에 사용한 것과 동일하다.
		 */
	}
}

/*
 * Servlet (Server + Let)
 * - 일반적인 자바 프로그램은 JavaSE -> main()이지만 웹에서는 main()이필요없다.
 * - 클래스 -> 서블릿의 형태로 변환해 줘야 한다.
 * - 서블릿은 특정 프로그램이 아니라 자바로 이루어져 있고 그 형태가 웹에서 동작할 수 있는 형태로 되어 있고
 * - 톰켓서버 (WAS)에 의해서 실행이 되는 클래스를 부르는 용어이다.
 * 
 * 기본 적인 골격을 위해 아래 3가지를 import 하자
 * import java.io.*;
 * import javax.servlet.*;
 * import javax.servlet.http.*;
 * public class HelloServlet extends HttpServlet {
 *		public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
 *	
 *		}
 *}
 *
 *위와 같은 형태가 기본적인 서블릿의 골격.
 *
 *          요청
 * client  ------>
 *         <-----   server(처리)
 *          응답(제공)
 *          
 * 
 */