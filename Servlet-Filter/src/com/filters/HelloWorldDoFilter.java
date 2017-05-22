package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class HelloWorldDoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {

			// 获取用户输入的URI
			HttpServletRequest req = (HttpServletRequest) request;
			String uri = req.getRequestURI().replaceAll(request.getServletContext().getContextPath(), "");
			
			if (uri.endsWith(".html") == true) {
				
				chain.doFilter(request, response);
				
			} else if (uri.equals("/HelloWorld.do") == true) {
				
				// 转发
				req.getRequestDispatcher("/HelloWorldDoServlet").forward(req, response);
				
			} else {
				
				// 转发
				req.getRequestDispatcher("/OtherDoServlet").forward(req, response);
			}

		} else {

			chain.doFilter(request, response);
		}
	}
}
