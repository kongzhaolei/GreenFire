package com.needle.greenfire.servlet;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.Setting;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetSettingInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Model model = new Model();
		String pid = request.getParameter("pid");
		String sid = request.getParameter("sid");
		if ((Utils.isNumeric(pid)) && (Utils.isNumeric(sid))) {
			Setting settingInfo = model.getSettingInfo(Integer.parseInt(sid),
					Integer.parseInt(pid));
			request.getSession().setAttribute("setting", settingInfo);
			request.getRequestDispatcher("settingInfo.jsp").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
