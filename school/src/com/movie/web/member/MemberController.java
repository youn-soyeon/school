package com.movie.web.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Separator;

@WebServlet({ "/member/login_form.do", "/member/join_form.do", "/member/join.do", "/member/login.do",
		"/member/admin.do", "/member/update_form.do", "/member/update.do", "/member/delete.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service = MemberServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("인덱스에서 들어옴");
		Command command = new Command();
		MemberBean member = new MemberBean();
		String[] arr = Separator.doSeparate(request);
		String directory = arr[0], action = arr[1];

		switch (action) {
		case "login":
			System.out.println("==로그인(login)==");
			if (service.isMember(request.getParameter("id")) == true) {
				member = service.login(request.getParameter("id"), request.getParameter("password"));
				if (member.getPassword() != null) {
					request.setAttribute("member", member);
					command = CommandFactory.createCommand(directory, "detail");
				} else {
					command = CommandFactory.createCommand(directory, "login_form");
				}
			} else {
				command = CommandFactory.createCommand(directory, "login_form");
			}
			break;
			
		case "join":
			System.out.println("==회원 가입(join)==");
			member.setId(request.getParameter("id"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth").replaceAll("-", "")));

			if (service.join(member) != 0) {
				command = CommandFactory.createCommand(directory, "login_form");
			} else {
				command = CommandFactory.createCommand(directory, "join_form");
			}
			break;

		case "update_form":
			System.out.println("==수정 폼으로 진입(update_form)==");
			request.setAttribute("member", service.detail(request.getParameter("id")));
			command = CommandFactory.createCommand(directory, action);
			break;

		
		case "update":
			System.out.println("==정보 수정(update)==");
			member.setId(request.getParameter("id"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth").replaceAll("-", "")));
			if (service.update(member) == 1) {
				request.setAttribute("member", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(directory, "detail");
			} else {
				request.setAttribute("member", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(directory, "update_form");
			}
			break;
			
		case "delete":
			System.out.println("==회원 탈퇴(delete)==");
			if (service.remove(request.getParameter("id")) == 1) {
				command = CommandFactory.createCommand(directory, "login_form");
			} else {
				request.setAttribute("member", service.remove(request.getParameter("id")));
				command = CommandFactory.createCommand(directory, "detail");
			}
			break;
		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}

		System.out.println("디렉토리 : " + directory);
		System.out.println("오픈될 페이지 : " + command.getView());

		DispatcherServlet.dispatcher(request, response, command.getView());
	}
}
