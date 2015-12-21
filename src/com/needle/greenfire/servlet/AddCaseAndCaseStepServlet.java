package com.needle.greenfire.servlet;

import com.google.gson.Gson;
import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.CaseStep;
import com.needle.greenfire.po.TestCase;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCaseAndCaseStepServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-");
		response.setCharacterEncoding("UTF-");
		response.setContentType("application/josn;charset=utf-");
		boolean flag = false;
		Model model = new Model();
		Map jsonMap = new HashMap();
		int pid = Integer.parseInt(request.getParameter("pid"));
		String runmode = request.getParameter("runmode");
		String title = request.getParameter("title");
		if (model.AddTestCase(checkTestCase(title, runmode,
				request.getParameter("pid")))) {
			int tcid = model.getAddTestCaseID(pid, title);
			String[] descs = (String[]) request.getParameterMap().get("desc");
			String[] knames = (String[]) request.getParameterMap().get("kname");
			String[] locators = (String[]) request.getParameterMap().get(
					"locator");
			String[] locatValues = (String[]) request.getParameterMap().get(
					"locatValue");
			String[] tsdatas = (String[]) request.getParameterMap().get(
					"tsdata");
			for (int i = 0; i < knames.length; i++) {
				if ((knames[i].equals("---璇烽�夋�?---"))
						|| (!model.addCaseStep(checkCaseStep(tcid, i + 1,
								descs[i], knames[i], locators[i],
								locatValues[i], tsdatas[i]))))
					continue;
				flag = true;
			}

		}

		if (flag)
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

	private TestCase checkTestCase(String title, String runmode, String pid) {
		TestCase tCase = new TestCase();
		if (Utils.isNumeric(pid)) {
			tCase.setPid(Integer.parseInt(pid));
			tCase.setRunmode(runmode);
			if (!Utils.isNull(title))
				tCase.setTitle(title);
			else {
				tCase.setTitle("");
			}
			tCase.setCreateTime(Utils.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		}
		return tCase;
	}

	private CaseStep checkCaseStep(int tcid, int tsid, String desc,
			String kname, String locator, String locatValue, String tsdata) {
		CaseStep caseStep = new CaseStep();
		caseStep.setTcid(tcid);
		caseStep.setTsid(tsid);
		if (!Utils.isNull(desc))
			caseStep.setNote(desc);
		else {
			caseStep.setNote("");
		}
		caseStep.setKname(kname);
		if (!locator.equals("---璇烽�夋�?---"))
			caseStep.setLocator(locator);
		else {
			caseStep.setLocator("");
		}
		if (!Utils.isNull(locatValue))
			caseStep.setLocatorValue(locatValue);
		else {
			caseStep.setLocatorValue("");
		}
		if (!Utils.isNull(tsdata))
			caseStep.setStrValue(tsdata);
		else {
			caseStep.setStrValue("");
		}
		caseStep.setCreateTime(Utils.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		return caseStep;
	}
}
