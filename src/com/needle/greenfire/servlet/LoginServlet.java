package com.needle.greenfire.servlet;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Model model = new Model();
		try {
			User user = model.userLogin(name, password);
			user.setUsername(name);
			ServletContext context = getServletContext();

			List nameList = (List) context.getAttribute("nameList");
			if (!nameList.contains(name)) {
				request.getSession().setAttribute("name", name);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("index.jsp");
			} else {
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			}
		} catch (Exception localException) {
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
