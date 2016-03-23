package com.movie.web.global;

/**
 * @file : Command.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 21.
 * @story directory와 action을 받아 view를 만드는 역할을 한다.
 */
public class Command {
	//상속할거면 protected, 안할거면 private
	private String directory, action, view;

	public Command() {}
	
	public Command(String directory, String action) {
		this.directory = directory;
		this.action = action;
		this.view = Constants.VIEWS + directory + "/" + action + ".jsp";
	}
	
	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}
	
}

/**
 * URL : http://localhost:9000/school/member/login_form.do
 * Context Path : http://localhost:9000/school
 * WebContent : /
 * URI(get 방식) : member/login_form.do?id=hong&password=1
 * URI(post 방식) : ember/login.do
 * 쿼리 스트링 구분자 : ?
 * 파라미터 구분자 : &
 * 쿼리 스트링 : id=hong&password=1
 * 
 * URI는 프로젝트 내부에서 유일한 값(ID) 이어야 하며,
 * 이 URI를 분해해서 서블릿에게 명령을 내리는 구조로 이뤄진다
 * */