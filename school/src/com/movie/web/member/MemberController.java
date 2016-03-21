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
import com.movie.web.global.Constants;

@WebServlet("/member/login_form.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 페이지 이동시에는 doGet (파라미터 없이 return)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("인덱스에서 들어옴");
//		RequestDispatcher dis = request.getRequestDispatcher(new Command(doProcess(request, response)[0], doProcess(request, response)[1]).getView());
		CommandFactory fac = new CommandFactory();
		RequestDispatcher dis = request.getRequestDispatcher(fac.getCommand(doProcess(request, response)[0], doProcess(request, response)[1]).getView());
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public String[] doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] arr = new String[2];
		String path = request.getServletPath();
		arr[0] = path.split("/")[1];
		arr[1] = path.split("/")[2].split("\\.")[0];
//		arr[1] = path.split("/")[2].substring(0, path.split("/")[2].indexOf("."));
//		arr[1] = path.split("/")[2].substring(0, path.split("/")[2].length()-3);
		return arr;
	}
}
