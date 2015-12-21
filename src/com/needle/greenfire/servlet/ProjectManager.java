package com.needle.greenfire.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.needle.greenfire.Model.Model;

public class ProjectManager extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Model model = new Model();
		Map prosMap = model.getAllProject();
		request.getSession().setAttribute("prosMap", prosMap);
		Collection prosList = prosMap.values();
		request.getSession().setAttribute("prosList", prosList);
		request.getRequestDispatcher("project.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
