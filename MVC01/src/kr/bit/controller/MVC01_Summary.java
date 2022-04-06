/*
 * 
 * 
 * 		MVC01
 * 
 * 		CLIENT   <---------------------------------------->   Controller(Servlet)<-------------------------------------------------> Model(Java)
 * 		/memberList.do										MemberListController			
 * 		/memberInsert.do									MemberInsertController													VO             JDBC-----------> 현재의 JDBC는 JAVA+SQL로 믹스되어 있다.
 * 		/memberContent.do									MemberContentController      <==> 현재는 컨트롤러가 1:1대응중이다. 				MemberDAO       <=>    DB       나중에는 분리한다. 분리된 JAVA와 SQL 연결에 myBatis를 사용한다.
 * 		/memberDelete.do									MemberDeleteController			    나중에는 단 하나의 컨트롤러를 사용한다.           
 * 		/memberUpdate.do									MemberUpdateController
 * 
 * 		
 * 		redirect 기법
 * 		- response.sendRedirect("/MVC01/memberList.do")
 * 
 * 
 * 		고객(CLIENT)         (새롭게 연결되면 끊어짐)           보험회사(SERVER)
 * 					(전화 요청) 교통사고
 * 		김고객		-------------------------------->  김대리(Controller)- 처리불가. 나과장에게 연결해줄게요. 혹시끊어지면 나과장에게 연락하세요.
 * 		 ^			<-------------------------------         |
 * 		 |				응답									 | redirect(전화 돌리기)
 * 		 |													 |					
 * 		 |													 |						      조대리(Model)
 * 		 |													 |
 * 		 |			요청      								     v
 * 		 |--------------------------------------------->  나과장 (교통사고 병원업무)
 * 					응답
 * 
 * 
 * 		redirect 기법
 * 		- response.sendRedirect("/MVC01/memberList.do")
 * 
 * 
 * 		고객(CLIENT)         (새롭게 연결되면 끊어짐)           SERVER
 * 					(가입 요청) /memberInsert.do             MemberInsertController(받아서)
 * 		김고객		-------------------------------->  Controller -------------------------
 * 		 ^			<-------------------------------         |							  |
 * 		 |				응답									 | redirect 				  |
 * 		 |													 |					          v  MemberDAO(로직처리)
 * 		 |													 |						    Model 
 * 		 |													 |(회원가입 완료 후 MemberInsertController가 응답해야 하지만 없어서 다음페이지를 MemberListController로 돌린다.)
 * 		 |			요청      								     v  response.sendRedirect("/MVC01/memberList.do")
 * 		 |--------------------------------------------->  MemberListController
 * 					응답
 */
