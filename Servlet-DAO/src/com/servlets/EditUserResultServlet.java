package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDaoImpl;
import com.models.User;

public class EditUserResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String passwd = request.getParameter("passwd");
		
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setTel(Integer.parseInt(tel));
		user.setPasswd(Integer.parseInt(passwd));
		
		// 更新数据库
		UserDaoImpl impl = new UserDaoImpl();
		impl.updateUser(user);
		
		// 转发到insert_success.jsp中
		request.getRequestDispatcher("edit_success.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
