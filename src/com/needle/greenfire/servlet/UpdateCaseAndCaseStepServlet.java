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

public class UpdateCaseAndCaseStepServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/josn;charset=utf-");
		Map jsonMap = new HashMap();
		Model model = new Model();
		int pid = Integer.parseInt(request.getParameter("pid"));
		int tcid = Integer.parseInt(request.getParameter("tcid"));
		String runmode = request.getParameter("runmode");
		String title = request.getParameter("title");
		if (model.updateTestCase(checkTestCase(tcid, title, runmode, pid))) {
			String[] tsids = (String[]) request.getParameterMap().get("tsid");
			String[] descs = (String[]) request.getParameterMap().get("desc");
			String[] knames = (String[]) request.getParameterMap().get("kname");
			String[] locators = (String[]) request.getParameterMap().get(
					"locator");
			String[] locatValues = (String[]) request.getParameterMap().get(
					"locatValue");
			String[] tsdatas = (String[]) request.getParameterMap().get(
					"tsdata");
			for (int i = 0; i < tsids.length; i++) {
				if (model
						.checkCaseStepID(pid, tcid, Integer.parseInt(tsids[i]))) {
					if (model.updateCaseStep(checkCaseStep(tcid, tsids[i],
							descs[i], knames[i], locators[i], locatValues[i],
							tsdatas[i]))) {
						jsonMap.put("state", "true");
					}
				} else if (model.addCaseStep(checkCaseStep(tcid, tsids[i],
						descs[i], knames[i], locators[i], locatValues[i],
						tsdatas[i])))
					jsonMap.put("state", "false");
			}
		} else {
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

	private TestCase checkTestCase(int tcid, String title, String runmode,
			int pid) {
		TestCase tCase = new TestCase();
		tCase.setPid(pid);
		tCase.setTcid(tcid);
		tCase.setRunmode(runmode);
		if (!Utils.isNull(title))
			tCase.setTitle(title);
		else {
			tCase.setTitle("");
		}
		return tCase;
	}

	private CaseStep checkCaseStep(int tcid, String tsid, String desc,
			String kname, String locator, String locatValue, String tsdata) {
		CaseStep caseStep = new CaseStep();
		caseStep.setTcid(tcid);
		caseStep.setTsid(Integer.parseInt(tsid));
		if (!Utils.isNull(desc))
			caseStep.setNote(desc);
		else {
			caseStep.setNote("");
		}
		if (!kname.equals("---璇烽�夋�?---"))
			caseStep.setKname(kname);
		else {
			caseStep.setKname("");
		}
		if (!Utils.isNull(locator))
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
