package com.movie.web.js;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Separator;

/**
 * @file : JavascriptController.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 24.
 * @story
 */
@WebServlet({ "/js/hello.do", "/js/var.do", "/js/operator.do", "/js/function.do", "/js/bom.do", "/js/dom.do",
		"/js/closure.do", "/js/form.do", "/js/object.do", "/js/pattern.do", })
public class JavascriptController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DispatcherServlet.dispatcher(request, response, CommandFactory
				.createCommand(Separator.doSeparate(request)[0], Separator.doSeparate(request)[1]).getView());
	}
}
