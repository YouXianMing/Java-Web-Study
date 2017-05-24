package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dao.UserDaoImpl;
import com.models.User;

public class EditUserFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		UserDaoImpl impl = new UserDaoImpl();
		User user = impl.findById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("user", user);
		chain.doFilter(request, response);
	}
}
