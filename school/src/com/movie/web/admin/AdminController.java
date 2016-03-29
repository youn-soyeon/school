package com.movie.web.admin;

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
import com.movie.web.member.MemberBean;

@WebServlet({"/admin/login_form.do","/admin/admin_form.do", "/admin/login.do", "/admin/logout.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("인덱스에서 들어옴");
		
		Command command = new Command();
		
		HttpSession session = request.getSession();
		
		AdminBean admin = new AdminBean();
		MemberBean member = new MemberBean();
		AdminService service = new AdminServiceImpl();
		
		String[] arr = Separator.doSeparate(request);
		String directory = arr[0], action = arr[1];

		switch (action) {
		
		case "admin_form":
			System.out.println("==관리자 폼으로 진입(admin_form)==");
			command = CommandFactory.createCommand(directory, action);
			break;
		case "member_list":
			System.out.println("==관리자 폼으로 진입(admin_form)==");
			member.setId(request.getParameter("id"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth").replaceAll("-", "")));
			command = CommandFactory.createCommand(directory, action);
			break;
		case "login":
			System.out.println("==관리자 로그인(login)==");
			admin.setId(request.getParameter("id"));
			admin.setPassword(request.getParameter("password"));
			AdminBean temp = service.getAdmin(admin);
			System.out.println("뭐야 : " + temp);
			System.out.println("아이디체크" + temp.getId().equals(admin.getId()));
			System.out.println("비번체크"+temp.getPassword().equals(admin.getPassword()));
			//temp.getId().equals(admin.getId()) && temp.getPassword().equals(admin.getPassword())
			if (temp != null) {
				System.out.println("관리자 로그인 성공");
				session.setAttribute("admin", temp);
				command = CommandFactory.createCommand(directory, "admin_form");
			} else {
				System.out.println("관리자 로그인 실패");
				command = CommandFactory.createCommand(directory, "login_form");
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
