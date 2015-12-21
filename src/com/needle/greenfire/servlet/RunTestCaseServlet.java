package com.needle.greenfire.servlet;

import com.google.gson.Gson;
import com.needle.greenfire.Model.Model;
import com.needle.greenfire.engine.RunCaseStep;
import com.needle.greenfire.po.CaseStep;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RunTestCaseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Model model = new Model();
		Map jsonMap = new HashMap();
		response.setContentType("application/josn;charset=utf-8");
		if (Utils.isNumeric(request.getParameter("pid"))) {
			int pid = Integer.parseInt(request.getParameter("pid"));

			String tcids_str = request.getParameter("tcid");
			String[] ids_str = null;
			if (tcids_str != "") {
				ids_str = tcids_str.split(",");
			}
			int[] ids = new int[ids_str.length];
			for (int i = 0; i < ids_str.length; i++) {
				ids[i] = Integer.parseInt(ids_str[i]);
			}
			String remodeUrl = model.getRemodeURL(pid, request.getRemoteHost());
			if (!Utils.isNull(remodeUrl)) {
				for (int i = 0; i < ids.length; i++) {
					RunCase(pid, ids[i], remodeUrl);
				}
				jsonMap.put("state", "true");
			} else {
				jsonMap.put("state", "false");
			}
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

	private static void RunCase(int pid, int tcid, String remodeUrl) {
		Model model = new Model();
		RunCaseStep rcs = null;
		try {
			rcs = new RunCaseStep();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		List csList = model.FindCaseStepInfo(pid, tcid);
		for (int i = 0; i < csList.size(); i++) {
			CaseStep cs = (CaseStep) csList.get(i);
			if (cs.getKname().equals("OpenBrowser"))
				RunCaseStep.executeTestCaseStep(cs.getKname(), cs.getLocator(),
						cs.getLocatorValue(), cs.getStrValue() + ";"
								+ remodeUrl);
			else
				RunCaseStep.executeTestCaseStep(cs.getKname(), cs.getLocator(),
						cs.getLocatorValue(), cs.getStrValue());
		}
	}
}
