package com.needle.greenfire.servlet;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.po.TestCase;
import com.needle.greenfire.utils.Utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = -7320823221456464463L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-");
		Model model = new Model();
		if ((!Utils.isNull(request.getParameter("pid")))
				&& (!Utils.isNull(request.getParameter("tcid")))) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			int tcid = Integer.parseInt(request.getParameter("tcid"));
			TestCase tc = model.findTestCaseInfo(pid, tcid);
			List csList = model.FindCaseStepInfo(pid, tcid);
			List knameList = model.findKeyNameInfo();
			request.getSession().setAttribute("cInfo", tc);
			request.getSession().setAttribute("cStepInfo", csList);
			request.getSession().setAttribute("KNames", knameList);
			request.getRequestDispatcher("caseInfo.jsp").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
