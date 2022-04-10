package kr.bit.frontController;

// View의 경로를 담당.
public class ViewResolver {
	public static String makeView(String nextPage) {
		return "/WEB-INF/member/"+nextPage+".jsp";
	}
}
