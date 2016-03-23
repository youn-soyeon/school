package com.movie.web.global;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @file : DispatcherServlet.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 23.
 * @story
 */
public class DispatcherServlet {
	public static void dispatcher(HttpServletRequest request, HttpServletResponse response, String view) {
		try {
			RequestDispatcher dis = request.getRequestDispatcher(view);			
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
