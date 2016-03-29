package com.movie.web.grade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.member.MemberService;
import com.movie.web.member.MemberServiceImpl;

@WebServlet({ "/grade/my_grade.do", "/grade/add_form.do" })
public class GradeController extends HttpServlet {
	GradeService service = GradeServiceImpl.getInstance();
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		String directory = path.split("/")[1];
		String action = path.split("/")[2].split("\\.")[0];
		
		MemberService m_service = MemberServiceImpl.getInstance(); 

		Command command = new Command();

		switch (action) {
		case "my_grade":
			System.out.println("==내 점수 보기(my_grade)==");
			request.setAttribute("score", service.getGradeById(request.getParameter("id")));
			command = CommandFactory.createCommand(directory, action);
			break;
		case "add_form":
			System.out.println("==학생 점수 추가 폼(add_form)==");
			System.out.println("request.getParameter 아이디 확인 : "+request.getParameter("id"));
			request.setAttribute("member", m_service.detail(request.getParameter("id")));
			command = CommandFactory.createCommand(directory, action);
			break;
		case "add":
			break;
		default:
			break;
		}
		System.out.println("디렉토리 : " + directory);
		System.out.println("오픈될 페이지 : " + command.getView());

		DispatcherServlet.dispatcher(request, response, command.getView());
	}

}
