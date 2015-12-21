package com.needle.greenfire.servlet;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.User;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = -2308828450843501871L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-");
		String username = request.getParameter("uname");
		String password = Utils.md5Encryption(request.getParameter("upwd"));
		String email = request.getParameter("uemail");
		String phone = request.getParameter("uphone");
		String state = "";
		String createTime = Utils.getCurrentDate("yyyy-MM-dd HH:mm:ss");
		Model model = new Model();
		if ((!Utils.isNull(username)) && (!Utils.isNull(username))) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			user.setState(state);
			user.setCreateTime(createTime);
			if (model.AddUser(user))
				request.getRequestDispatcher("userManager").forward(request,
						response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
