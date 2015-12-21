package com.needle.greenfire.servlet;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.Setting;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateSettingInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Model model = new Model();
		Setting setting = new Setting();
		int sid = Integer.parseInt(request.getParameter("sid"));
		String aliasName = request.getParameter("aname");
		String remodeUrl = request.getParameter("rurl");
		String localIP = request.getParameter("ip");
		setting.setSid(sid);
		if (!Utils.isNull(aliasName))
			setting.setAliasName(aliasName);
		else {
			setting.setAliasName("");
		}
		if (!Utils.isNull(aliasName))
			setting.setRemodeUrl(remodeUrl);
		else {
			setting.setRemodeUrl("");
		}
		if (!Utils.isNull(aliasName))
			setting.setLocalIP(localIP);
		else {
			setting.setLocalIP("");
		}
		if (model.updateSetting(setting))
			request.getRequestDispatcher("setting.jsp").forward(request,
					response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
