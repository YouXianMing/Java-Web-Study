package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class NormalFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("进入过滤器 NormalFilter");
		request.getRequestDispatcher("/manager").forward(request, response);
		System.out.println("离开过滤器 NormalFilter");
	}
}
