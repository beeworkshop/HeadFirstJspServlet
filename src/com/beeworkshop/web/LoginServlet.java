package com.beeworkshop.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beeworkshop.dao.UserDao;
import com.beeworkshop.model.User;
import com.beeworkshop.util.DbUtil;

public class LoginServlet extends HttpServlet {

	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		Connection conn = null;
		try {
			User user = new User(userName, password);
			conn = dbUtil.getConn();
			User currentUser = userDao.login(conn, user);
			if (currentUser == null) {
				System.out.println("fail");
				request.setAttribute("error", "用户名或者密码错误");
				request.setAttribute("userName", userName);
				request.setAttribute("password", password);
				request.getRequestDispatcher("login.jsp").forward(request, response); // Servlet内部转发，request属性可以传递
			} else {
				System.out.println("success");
				HttpSession session = request.getSession();
				session.setAttribute("currentUser", currentUser);
				response.sendRedirect("main.jsp");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
