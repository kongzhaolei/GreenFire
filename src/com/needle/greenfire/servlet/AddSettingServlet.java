package com.needle.greenfire.servlet;

import com.google.gson.Gson;
import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.Setting;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddSettingServlet extends HttpServlet {

	private static final long serialVersionUID = 3640530348307943067L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-");
		Model model = new Model();
		Map jsonMap = new HashMap();
		String pid = request.getParameter("pid");
		String aliasName = request.getParameter("aName");
		String remodeURL = request.getParameter("rURL");
		String localIP = request.getParameter("ip");
		String createTime = Utils.getCurrentDate("yyyy-MM-dd HH:mm:ss");
		if (model.addProjectSetting(AddSetting(pid, aliasName, remodeURL,
				localIP, createTime)))
			jsonMap.put("state", "true");
		else {
			jsonMap.put("state", "false");
		}
		Gson gson = new Gson();
		String result = gson.toJson(jsonMap);
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private static Setting AddSetting(String pid, String aliasName,
			String remodeURL, String localIP, String createTime) {
		Setting setting = new Setting();
		if ((!Utils.isNull(pid)) && (Utils.isNumeric(pid))) {
			setting.setPid(Integer.parseInt(pid));
			if (!Utils.isNull(aliasName))
				setting.setAliasName(aliasName);
			else {
				setting.setAliasName("");
			}
			if (!Utils.isNull(remodeURL))
				setting.setRemodeUrl(remodeURL);
			else {
				setting.setRemodeUrl("");
			}
			if (!Utils.isNull(localIP))
				setting.setLocalIP(localIP);
			else {
				setting.setLocalIP("");
			}
			setting.setCreateTime(createTime);
		}

		return setting;
	}
}
