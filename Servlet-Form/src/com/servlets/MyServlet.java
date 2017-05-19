package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Get at: ").append(request.getContextPath() + "\n");
		response.getWriter().append("param1 : " + request.getParameter("param1") + "\n");
		response.getWriter().append("param2 : " + request.getParameter("param2") + "\n");
		response.getWriter().append("param3 : " + request.getParameter("param3") + "\n");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Post at: ").append(request.getContextPath() + "\n");
		response.getWriter().append("param1 : " + request.getParameter("param1") + "\n");
		response.getWriter().append("param2 : " + request.getParameter("param2") + "\n");
		response.getWriter().append("param3 : " + request.getParameter("param3") + "\n");
	}
}

