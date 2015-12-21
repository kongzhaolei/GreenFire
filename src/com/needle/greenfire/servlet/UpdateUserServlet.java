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

public class UpdateUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Model model = new Model();
		User user = new User();
		String username = request.getParameter("uname");
		String password = request.getParameter("upwd");
		String email = request.getParameter("uemail");
		String phone = request.getParameter("uphone");
		String state = "";
		String createTime = Utils.getCurrentDate("yyyy-MM-dd HH:mm:ss");
		if ((!Utils.isNull(username)) && (!Utils.isNull(password))) {
			if (!model.checkPassWord(username, password)) {
				password = Utils.md5Encryption(request.getParameter("upwd"));
			}
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			user.setState(state);
			user.setCreateTime(createTime);
			if (model.updateUser(user))
				request.getRequestDispatcher("userManager").forward(request,
						response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
