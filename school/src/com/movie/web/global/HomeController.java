package com.movie.web.global;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/global/main.do")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==메인(main)==");
		String path = request.getServletPath();
		String directory = path.split("/")[1];
		String action = path.split("/")[2].split("\\.")[0];

		Command command = CommandFactory.createCommand(directory, action);

		System.out.println("디렉토리 : " + directory);
		System.out.println("오픈될 페이지 : " + command.getView());

		RequestDispatcher dis = request.getRequestDispatcher(command.getView());
		dis.forward(request, response);
	}

}
