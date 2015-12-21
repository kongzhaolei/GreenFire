package com.needle.greenfire.servlet;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.Project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProjectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int pid = Integer.parseInt(request.getParameter("pid"));
		String proname = request.getParameter("pname");
		String prodesc = request.getParameter("pdesc");
		Model model = new Model();
		Project project = new Project();
		project.setPid(pid);
		project.setProname(proname);
		project.setDescribe(prodesc);
		if (model.UpdateProject(project))
			request.getRequestDispatcher("projectManager").forward(request,
					response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
