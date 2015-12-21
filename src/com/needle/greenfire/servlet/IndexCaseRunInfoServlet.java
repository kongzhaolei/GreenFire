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

public class IndexCaseRunInfoServlet extends HttpServlet {
	private static final long serialVersionUID = -2399125296752964815L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/josn;charset=utf-");
		Model model = new Model();
		List runinfoList = model.findCaseRunInfo();
		Gson gson = new Gson();
		String result = gson.toJson(runinfoList);
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
