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

@WebServlet({ "/member/login_form.do", "/member/join_form.do", "/member/join.do", "/member/login.do",
		"/member/admin.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 페이지 이동시에는 doGet (파라미터 없이 return)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("인덱스에서 들어옴");

		MemberService service = new MemberServiceImpl();
		MemberBean member = new MemberBean();
		String path = request.getServletPath();
		String directory = path.split("/")[1];
		String action = path.split("/")[2].split("\\.")[0];

		Command command = new Command();

		switch (action) {
		case "join":
			String id = request.getParameter("id");
			System.out.println("아이디 : " + id);
			break;
		case "login":
			System.out.println("==로그인==");
			if(service.isMember(request.getParameter("id")) == true) {
				member = service.login(request.getParameter("id"), request.getParameter("password"));
				if(member.getPassword() != null){
					request.setAttribute("member", member);
					command = CommandFactory.createCommand(directory, "detail");
				} else {
					command = CommandFactory.createCommand(directory, "login_form");
				}
			} else {
				command = CommandFactory.createCommand(directory, "login_form");				
			}
			break;

		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}

		System.out.println("디렉토리 : " + directory);
		System.out.println("오픈될 페이지 : " + command.getView());

		RequestDispatcher dis = request.getRequestDispatcher(command.getView());
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
