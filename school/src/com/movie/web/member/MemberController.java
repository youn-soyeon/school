package com.movie.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.Separator;

@WebServlet({ "/member/login_form.do", "/member/join_form.do", "/member/join.do", "/member/login.do",
		"/member/admin.do", "/member/update_form.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service = MemberServiceImpl.getInstance();

	// 페이지 이동시에는 doGet (파라미터 없이 return)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("인덱스에서 들어옴");
		Command command = new Command();
		MemberBean member = new MemberBean();
		String[] arr = Separator.doSeparate(request);

		switch (arr[2]) {
//		case "join":
//			member.setId(request.getParameter("id"));
//			member.setName(request.getParameter("name"));
//			member.setPassword(request.getParameter("password"));
//			member.setAddr(request.getParameter("addr"));
//			member.setBirth(Integer.parseInt(request.getParameter("birth")));
//			if (service.join(member) != 0) {
//				command = CommandFactory.createCommand(arr[1], "login_form");
//			} else {
//				command = CommandFactory.createCommand(arr[1], "join_form");
//			}
//			break;
		case "login":
			System.out.println("==로그인==");
			if(service.isMember(request.getParameter("id")) == true) {
				member = service.login(request.getParameter("id"), request.getParameter("password"));
				if(member.getPassword() != null){
					request.setAttribute("member", member);
					command = CommandFactory.createCommand(arr[1], "detail");
				} else {
					command = CommandFactory.createCommand(arr[1], "login_form");
				}
			} else {
				command = CommandFactory.createCommand(arr[1], "login_form");				
			}
			break;
		case "update_form":
			System.out.println("==수정 폼으로 진입==");
			request.setAttribute("member", service.detail(request.getParameter("id")));
			command = CommandFactory.createCommand(arr[1], arr[2]);
			break;

		default:
			command = CommandFactory.createCommand(arr[1], arr[2]);
			break;
		}

		System.out.println("디렉토리 : " + arr[1]);
		System.out.println("오픈될 페이지 : " + command.getView());

		RequestDispatcher dis = request.getRequestDispatcher(command.getView());
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = new Command();
		MemberBean member = new MemberBean();
		String[] arr = Separator.doSeparate(request);
		
		switch (arr[2]) {
		case "join":
			member.setId(request.getParameter("id"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth").replaceAll("-", "")));
			if (service.join(member) != 0) {
				command = CommandFactory.createCommand(arr[1], "login_form");
			} else {
				command = CommandFactory.createCommand(arr[1], "join_form");
			}
			break;

		default:
			command = CommandFactory.createCommand(arr[1], arr[2]);
			break;
		}
		
		System.out.println("디렉토리 : " + arr[1]);
		System.out.println("오픈될 페이지 : " + command.getView());

		RequestDispatcher dis = request.getRequestDispatcher(command.getView());
		dis.forward(request, response);
	}
}
