package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class URIFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {

			HttpServletRequest req = (HttpServletRequest) request;

			// 设置参数
			req.setAttribute("ContextPath", req.getServletContext().getContextPath());
			req.setAttribute("RequestURI", req.getRequestURI());
			req.setAttribute("URI", req.getRequestURI().replaceAll(request.getServletContext().getContextPath(), ""));
		}

		System.out.println("进入过滤器 URIFilter");
		chain.doFilter(request, response);
		System.out.println("离开过滤器 URIFilter");
	}
}
