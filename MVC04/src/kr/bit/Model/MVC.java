/*
 * 
 * ClIENT                                                SERVER
 * 																		Controller(POJO, Plain Old Java Object)
 * /memberList.do														
 * /memberInsert.do														Contontroller(interface) -----> requestHandler()[추상메서드]
 * /memberDelete.do  ----------> FrontController  ------------>			       ^
 * /memberContent.do                (Server)								   |
 * /memberUpdate.do														MemberListController
 * 																		MemberContentController
 * 																		MemberInsertController
 * 																		MemberUpdateController
 * 																		MemberDeleteController
 * 
 * 
 * POJO
 * - 일반 자바 클래스.
 * 
 * FrontController
 * - 서블릿(자바)
 * 
 * JSP 파일을 WEB-INF(보안 디렉터리)로 옮기자.
 * - 클라이언트가 컨트롤러를 거치지 않고 뷰를 요청하는 것을 막기 위해서 옮긴다.
 * - 보안 디렉터리는 웹에서 사용불가.
 * 
 * 언제 redirect를 쓰고 forward를 쓸까?
 * 우선 구분이 쉽게 URL 앞에 redirect인 경우에만 redirect:를 붙여준다.
 * 1. redirect
 * - ex) delete 하면 리스트 페이지로 간다. redirect
 * 2. forward
 * - 디비에서 데이터를 가져와 객체바인딩과 setAttribute를 한다. forward
 * 
 * 
 * 현재는 else if를 클래스로 따로 뺀다
 * FrontController  ------------> HandlerMapping
 * 								
 * HandlerMapping (HashMAP)
 *    	KEY					VALUE
 * /memberList.do   	new MemberListController()
 * /memberInsert.do		new MemberInsertController()    
 *    
 * - ViewResolver 클래스를 만들어서 경로를 관리.    
 * - 톰켓 서버에 등록된 컨텍스트 패스가 변경되어도 원래 경로 유지하는 방법.
 *   - server.xml의 Context Path를 자동으로 가져와서 출력하자.
 * - String ctx = request.getContextPath(); --> POJO에서 Context Path 가져오는 방법
 * - <c:set var="ctx" value=${pageContext.request.contextPath }/> --> jsp에서 Context Path 가져오는 방법
 * 
 * MVC04의 문제점
 * POJO가 너무 많다. MVC05에서 1개로 줄인다.!
 * 그리고 MVC05에서 JDBC => MyBatis로 변경.
 *    
 */