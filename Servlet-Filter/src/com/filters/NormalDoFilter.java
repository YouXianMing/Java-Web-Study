package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NormalDoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {

			// 获取用户输入的URI
			HttpServletRequest req = (HttpServletRequest) request;
			String uri = req.getRequestURI().replaceAll(request.getServletContext().getContextPath(), "");
			
			// 判断URI是否是"/notice.html"(防止无限循环),或者符合"*.do"模板,如果是,则放行,如果不是,则重定向到/notice.html
			if (uri.equals("/notice.html") || uri.endsWith(".do") == true) {
				
				chain.doFilter(request, response);
				
			} else {
				
				// 重定向
				HttpServletResponse rsp = (HttpServletResponse)response;
				rsp.sendRedirect("notice.html");
			}

		} else {

			chain.doFilter(request, response);
		}
	}
}
