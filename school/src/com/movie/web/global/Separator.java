package com.movie.web.global;

import javax.servlet.http.HttpServletRequest;

public class Separator {
	private static String path, directory, action;
	
	public static String[] doSeparate(HttpServletRequest request) {
		path = request.getServletPath();
		directory = path.split("/")[1];
		action = path.split("/")[2].split("\\.")[0];
		String[] str = {path, directory, action};
		return  str;
	}
}
