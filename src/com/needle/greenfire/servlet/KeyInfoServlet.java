package com.needle.greenfire.servlet;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.KeyWord;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KeyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 4086886187550514335L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Model model = new Model();
		if (!Utils.isNull(request.getParameter("kid"))) {
			int kid = Integer.parseInt(request.getParameter("kid"));
			KeyWord keyInfo = model.getKeyWordInfo(kid);
			request.getSession().setAttribute("keyInfo", keyInfo);
			request.getRequestDispatcher("keywordInfo.jsp").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
