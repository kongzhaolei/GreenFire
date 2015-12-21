package com.needle.greenfire.servlet;

import com.google.gson.Gson;
import com.needle.greenfire.Model.Model;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class findSettingInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 4861072885376796817L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/josn;charset=utf-");
		Model model = new Model();
		String pid = request.getParameter("pid");
		if ((Utils.isNumeric(pid)) && (!pid.equals(" --- 鐠囩兘锟藉瀚� --- "))) {
			Map settingMap = model.findSettingInfo(Integer.parseInt(pid));
			Gson gson = new Gson();
			String result = gson.toJson(settingMap);
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
