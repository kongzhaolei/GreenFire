package com.needle.greenfire.servlet;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.Project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProjectServlet extends HttpServlet {
	private static final long serialVersionUID = -1860714453075008260L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-");
		String proName = request.getParameter("newProname");
		String proDesc = request.getParameter("newProdesc");
		Model model = new Model();
		Project project = new Project();
		project.setProname(proName);
		project.setDescribe(proDesc);
		if (model.AddProject(project))
			request.getRequestDispatcher("projectManager").forward(request,
					response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
