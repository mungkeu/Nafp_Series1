/*
 * 
 * 
 * MVC
 * 
 *                  요청(ex:list)													 JavaDAO		   CRUE(JDBC)
 * Client------------------------> Controller(Servlet) <========================> Model(Java) <=================>DB
 *   ^	 <----------------------->	|   ^  ^
 *   |			      (setAttribute)|	|  | Controller가 View 요청				
 *   |					        객체바인딩	|	|   ---> 요청의뢰 객체 (Request Dispatcher)
 *   |				  (getAttribute)|	|  |  요청의뢰 객체가 View를 찾아준다.  
 *   |								v	|  v											
 *   |--------------------------->  View (JSP)
 *   
 *   
 *   
 *   
 *   요청 의뢰(Request Dispatcher, 요청의뢰 객체) 어떻게 요청할까?
 *   Controller에 있는 list를 어떻게 View가 가져갈까?   이 두 부분을 forward(포워드)라고한다. 아주중요!!
 *   Controller가 가지고 있는 데이터를 View가 가지고 가는 기술을 객체 바인딩이라고 한다.!!
 *   
 *  MVC03의 핵심
 *  1. Request Dispatcher : Controller의 요청을 받아 원하는 View를 찾아서 알려준다.
 *  2. forward : Controller와 View가 데이터를 주고받고 하는 부분
 *  3. 객체 바인딩 : Controller의 데이터를 View로 전달한다.  
 *               - 즉 Controller가 특정 메모리에 데이터를 집어 넣어둔다.
 *               - 넣어준다해서 setAttribute
 *               - 이렇게 넣어두면 View가 언제든지 빼갈 수 있다.(getAttribute)
 *               
 *  
 *        /memberList.do(회원목록)												 JavaDAO		   CRUE(JDBC)
 * Client------------------------> Controller(Servlet) <========================> Model(Java) <=================>DB
 *   ^	 <----------------------->	|   ^  ^
 *   |			             		|	|  | 			
 *   |					        객체바인딩	|	|   ---> 요청의뢰 객체 (Request Dispatcher)
 *   |				 				|	|  |      RequestDispatcher rd = request.getRequestDispatcher("memberList.jsp);
 *   |								v	|  v			                              요청을 의뢰한 페이지를 얻어온다. memberList.jsp에서								
 *   |--------------------------->  View (JSP)
 *   
 *   HttpServletRequest와 HttpServletResponse를 가리키고 있는 request, response 객체가 같아야 한다.
 *   
 *   정리
 *   1. 고객이 페이지를 요청한다.
 *   2. 컨트롤러는 디스패처에 고객이 요청한 페이지에 맞는 뷰를 요청한다. (고객이 넘겨준 request와 response도 같이 준다.)
 *   3. 디스패처가 맞는 뷰를 찾아내면 forewar() 메서드를 사용해서 JSP뷰 페이지에게 컨트롤러가 가지고 있던 request와 response를 전달해준다. (rd.forward(request, response);)
 *   4. 그럼 컨트롤러가 가지고 있던 데이터를 뷰가 어떻게 가지고 가냐면, request에 담겨져 있다. 이것을 객체 바인딩이라고한다. (request.setAttribute("list",list);   arrayList, object
 *   5. 이제 뷰에서는 request를 사용해서 데이터를 빼내온다. (request.getAttribute("list");       arrayList로 캐스팅. object로 나오기 때문.
 *   6. 뷰에서 처리후 response객체를 사용해 다시 컨트롤러에 전달해준다.
 *   7. 컨트롤러는 받은 데이터를 고객에게 응답해준다.
 *   
 *   이런 컨트롤러와 디스패처객체 뷰의 데이터가 와따가따하는걸 포워드라고한다.
 *   
 *      CLIENT				      요청				Controller(Servlet)
 *   /memberList.do       <------------>     - MemberListController
 *   /memberInsert.do	  <------------>     - MemberInsertController				Model(Java)			JDBC
 *   /memberDelete.do	  <------------>     - MemberDeleteController      <=====>   MemberDAO        <---------> DB   
 *   /memberContent.do	  <------------>     - MemberContentController									CRUD
 *   /memberUpdate.do	  <------------>     - MemberUpdateController
 *   						      응답                                    |
 *   					<--------------------------|   |
 *   											   |   |
 *   											   |   |
 *   											   |   |
 *   											   v   v
 *   											   View(JSP)
 *   											 memberList.jsp
 *   											 memberContent.jsp
 *   											 memberRegister.jsp
 *   
 *   JSTL(JSP 표준 태그 라이브러리) MVN Repository에서 라이브러리 다운.
 *   - <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 *   - uri는 jstl 쓰려면 적어줘야한다.
 *	 - prefix는 그냥 접두어를 정하는것 c는 맘대로적는것. 예전부터 그냥 c로 한듯.
 *	 - core, fmt, functions, xml 등 많이 지원한다. 많이 쓰는건 core 
 *   - <c:> : 이렇게 사용 컨트롤 스페이스로 쓰고싶은거 사용
 *   
 *     EL
 *   - JSTL을 출력하기 위해서 사용
 *   - ${jstl변수 등}
 *   - 조건문, 연산등 가능.
 *   
 *   내부적으로 JSP 파일은 서블릿으로 변환되므로 사실 내부적으로는 아래와 같이 동작.
 *   JSTL의 var => request.setAttribute("i", i);
 *                          ^
 *                          |
 *                          v
 *   EL의   ${i} => <%=request.getAttribute("i")%>
 *   
 *   현재의 문제점.
 *   - 컨트롤러의 갯수가 너무 많다.!!!
 *   - MVC04 에서 FrontController(서블릿)만들고 도와주는 POJOController(Java객체, Plain old java Object)
 *   - 컨트롤러를 하나로 만들고 여러개의 포조를 만드는 형식.
 */