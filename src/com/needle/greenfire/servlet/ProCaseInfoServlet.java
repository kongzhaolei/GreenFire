package com.needle.greenfire.servlet;

import com.google.gson.Gson;
import com.needle.greenfire.Model.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProCaseInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("pid"));
		Model model = new Model();
		List proCaseInfoList = model.FindProCaseInfo(id);
		Gson gson = new Gson();
		String result = gson.toJson(proCaseInfoList);
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
