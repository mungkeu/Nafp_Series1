package kr.bit.frontController;

import java.util.HashMap;

import kr.bit.controller.*;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/memberList.do",  new MemberListController());
		mappings.put("/memberInsert.do",  new MemberInsertController());
		mappings.put("/memberRegister.do",  new MemberRegisterController());
		mappings.put("/memberContent.do",  new MemberContentController());
		mappings.put("/memberUpdate.do",  new MemberUpdateController());
		mappings.put("/memberDelete.do",  new MemberDeleteController());
	}
	
	public Controller getController(String key) { // key=>memberList.do
		return mappings.get(key);
	}
}


//요청에 따른 분기작업 (HandlerMappint)
//		if (command.equals("/memberList.do")) { // 회원 리스트 보기
//			controller = new MemberListController();
//			nextPage = controller.requestHandler(request, response);
//
//		} else if (command.equals("/memberInsert.do")) { // 회원 가입
//			controller = new MemberInsertController();
//			nextPage = controller.requestHandler(request, response);
//
//		} else if (command.equals("/memberRegister.do")) { // 회원가입 화면
//			controller = new MemberRegisterController();
//			nextPage = controller.requestHandler(request, response);
//
//		} else if (command.equals("/memberContent.do")) { // 회원 상세보기
//			controller = new MemberContentController();
//			nextPage = controller.requestHandler(request, response);
//
//		} else if (command.equals("/memberUpdate.do")) { // 회원 정보 수정
//			controller = new MemberUpdateController();
//			nextPage = controller.requestHandler(request, response);
//
//		} else if (command.equals("/memberDelete.do")) { // 회원 삭제
//			controller = new MemberDeleteController();
//			nextPage = controller.requestHandler(request, response);
//		}