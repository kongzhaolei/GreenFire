package com.needle.greenfire.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.needle.greenfire.Model.Model;

public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 917962869741651550L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String user_str = request.getParameter("usersId");
		String[] ids_str = null;
		if (user_str != "") {
			ids_str = user_str.split(",");
		}
		int[] ids = new int[ids_str.length];
		for (int i = 0; i < ids_str.length; i++) {
			ids[i] = Integer.parseInt(ids_str[i]);
		}
		Model model = new Model();
		if (model.DeleteUser(ids))
			request.getRequestDispatcher("userManager").forward(request,
					response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
