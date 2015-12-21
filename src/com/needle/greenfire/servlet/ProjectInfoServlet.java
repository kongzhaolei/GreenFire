package com.needle.greenfire.servlet;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.Project;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-");
		int pid = Integer.parseInt(request.getParameter("pid"));
		Model model = new Model();
		if (!Utils.isNull(request.getParameter("pid"))) {
			Project proInfo = model.getProjectInfo(pid);
			request.getSession().setAttribute("proInfo", proInfo);
			request.getRequestDispatcher("proInfo.jsp").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
