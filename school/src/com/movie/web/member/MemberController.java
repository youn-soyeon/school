package com.movie.web.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Separator;

@WebServlet({ "/member/login_form.do", "/member/join_form.do", "/member/join.do", "/member/login.do",
		"/member/admin.do", "/member/update_form.do", "/member/update.do", "/member/delete.do", "/member/list.do",
		"/member/search.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service = MemberServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("인덱스에서 들어옴");
		String[] arr = Separator.doSeparate(request);
		String directory = arr[0], action = arr[1];
		
		MemberBean member = new MemberBean();
		
		Command command = new Command();
		HttpSession session = request.getSession();

		switch (action) {
		case "login":
			System.out.println("==로그인(login)==");
			if (service.isMember(request.getParameter("id")) == true) {
				System.out.println("==아이디가 존재함==");
				member = service.login(request.getParameter("id"), request.getParameter("password"));
				if (member == null) {
					command = CommandFactory.createCommand(directory, "login_form");
				} else {
					session.setAttribute("user", member);//BOM에 해당
					command = CommandFactory.createCommand(directory, "detail");
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
			member.setMajor(request.getParameter("major"));
			member.setSubject(request.getParameter("subject"));

			if (service.join(member) != 0) {
				command = CommandFactory.createCommand(directory, "login_form");
			} else {
				command = CommandFactory.createCommand(directory, "join_form");
			}
			break;

		case "update_form":
			System.out.println("==수정 폼으로 진입(update_form)==");
			command = CommandFactory.createCommand(directory, action);
			break;

		
		case "update":
			System.out.println("==정보 수정(update)==");
			member.setId(request.getParameter("id"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth").replaceAll("-", "")));
			member.setMajor(request.getParameter("major"));
			member.setSubject(request.getParameter("subject"));
			if (service.update(member) == 1) {
				session.setAttribute("user", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(directory, "detail");
			} else {
				command = CommandFactory.createCommand(directory, "update_form");
			}
			break;
			
		case "delete":
			System.out.println("==회원 탈퇴(delete)==");
			if (service.remove(request.getParameter("id")) == 1) {
				command = CommandFactory.createCommand(directory, "login_form");
			} else {
				command = CommandFactory.createCommand(directory, "detail");
			}
			break;
		case "list":
			request.setAttribute("list", service.getList());
			command = CommandFactory.createCommand(directory, "member_list");
			break;
		case "logout":
			session.invalidate(); // BOM에 있는 객체 없앰 => DOM에 있는 객체도 사라짐 => 보안up!
			System.out.println("==로그아웃 성공==");
			command = CommandFactory.createCommand(directory, "login_form");
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
