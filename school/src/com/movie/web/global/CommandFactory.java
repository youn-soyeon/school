package com.movie.web.global;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @file : CommandFactory.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 21.
 * @story
 */
public class CommandFactory {
	public static Command getCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		String directory = path.split("/")[1];
		String action = "";
		String queryString = "";
		if (path.indexOf("?") == -1) {
			action = path.split("/")[2].split("\\.")[0];
		} else {
			action = path.split("/")[2].split("\\.")[0].split("?")[0];
			queryString = path.split("/")[2].split("\\.")[0].split("?")[1];
		}
		return new Command(directory, action);
	}

	public static Command createCommand(String directory, String action) {
		return new Command(directory, action);
	}
}
