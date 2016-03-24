package com.movie.web.grade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;

@WebServlet({ "/grade/my_grade.do" })
public class GradeController extends HttpServlet {
	GradeService service = GradeServiceImpl.getInstance();
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		String directory = path.split("/")[1];
		String action = path.split("/")[2].split("\\.")[0];

		Command command = new Command();

		switch (action) {
		case "my_grade":
			System.out.println("==내 점수 보기(my_grade)==");
			request.setAttribute("score", service.getGradeById(request.getParameter("id")));
			command = CommandFactory.createCommand(directory, action);
			break;

		default:
			break;
		}
		System.out.println("디렉토리 : " + directory);
		System.out.println("오픈될 페이지 : " + command.getView());

		RequestDispatcher dis = request.getRequestDispatcher(command.getView());
		dis.forward(request, response);
	}

}
