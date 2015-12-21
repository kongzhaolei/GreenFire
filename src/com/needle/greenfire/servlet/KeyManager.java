package com.needle.greenfire.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.needle.greenfire.Model.Model;

public class KeyManager extends HttpServlet {
	private static final long serialVersionUID = -6903484100242630753L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Model model = new Model();
		Map keysMap = model.findAllKeyWord();
		request.getSession().setAttribute("keysMap", keysMap);
		Collection keysList = keysMap.values();
		request.getSession().setAttribute("keysList", keysList);
		request.getRequestDispatcher("keyword.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
