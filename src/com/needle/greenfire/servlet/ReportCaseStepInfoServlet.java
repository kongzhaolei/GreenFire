package com.needle.greenfire.servlet;

import com.google.gson.Gson;
import com.needle.greenfire.Model.Model;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReportCaseStepInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/josn;charset=utf-");
		if (Utils.isNumeric(request.getParameter("pid"))) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			Model model = new Model();
			List reportCases = model.FindCaseStepInfo(pid);
			Gson gson = new Gson();
			String result = gson.toJson(reportCases);
			PrintWriter out = response.getWriter();
			out.write(result);
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
