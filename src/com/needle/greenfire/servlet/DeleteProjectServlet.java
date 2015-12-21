package com.needle.greenfire.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.needle.greenfire.Model.Model;

public class DeleteProjectServlet extends HttpServlet {
	private static final long serialVersionUID = -6226468090039745506L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pro_str = request.getParameter("proIds");
		String[] ids_str = null;
		if (pro_str != "") {
			ids_str = pro_str.split(",");
		}
		int[] ids = new int[ids_str.length];
		for (int i = 0; i < ids_str.length; i++) {
			ids[i] = Integer.parseInt(ids_str[i]);
		}
		Model model = new Model();
		if (model.DeleteProject(ids))
			request.getRequestDispatcher("projectManager").forward(request,
					response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
