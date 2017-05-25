package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDaoImpl;
import com.models.User;

public class InsertUserResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String passwd = request.getParameter("passwd");
		
		if (id.length() <= 0) {
			
			request.setAttribute("error", "id不能为空!");
			request.getRequestDispatcher("insert_error.jsp").forward(request, response);
			return;
		}
		
		if (name.length() <= 0) {
			
			request.setAttribute("error", "用户名不能为空!");
			request.getRequestDispatcher("insert_error.jsp").forward(request, response);
			return;
		}
		
		// 创建用户
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setTel(Integer.parseInt(tel));
		user.setPasswd(Integer.parseInt(passwd));
		
		// 插入数据库
		UserDaoImpl impl = new UserDaoImpl();
		impl.insertUser(user);
		
		// 转发到insert_success.jsp中
		request.getRequestDispatcher("insert_success.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
