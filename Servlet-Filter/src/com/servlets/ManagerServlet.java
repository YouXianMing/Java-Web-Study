package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("ContextPath : ").append(request.getAttribute("ContextPath").toString() + "\n");
		response.getWriter().append("RequestURI  : ").append(request.getAttribute("RequestURI").toString() + "\n");
		response.getWriter().append("URI         : ").append(request.getAttribute("URI").toString() + "\n");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
