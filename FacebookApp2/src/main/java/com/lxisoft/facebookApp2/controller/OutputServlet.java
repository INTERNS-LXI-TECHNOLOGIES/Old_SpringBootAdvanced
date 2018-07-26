package com.lxisoft.facebookApp2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.*;

import com.lxisoft.facebookApp2.model.Output;

/**
 * The OutputServlet class is an Controller of output page
 * 
 * @author SARATHKRISHNA S
 * @version 1.0
 * @since 2018-07-24
 */
public class OutputServlet extends HttpServlet {
	private final Logger slf4jLogger = LoggerFactory.getLogger(OutputServlet.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		slf4jLogger.info("Signed in to Output Controller doGet function");
		Output output = new Output();
		HttpSession session = request.getSession();
		session.setAttribute("uname", "UserName");
		session.setAttribute("uscore", "60");

		output.setUserName((String) session.getAttribute("uname"));
		output.setUserScore(Integer.parseInt((String) session.getAttribute("uscore")));
		session.setAttribute("Output", output);
		RequestDispatcher view = request.getRequestDispatcher("output.jsp");
		view.forward(request, response);
		slf4jLogger.info("forward to output.jsp");
	}
}