package com.needle.greenfire.engine;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.browser.ActionKeywords;
import com.needle.greenfire.po.CaseStep;
import com.needle.greenfire.po.Project;
import com.needle.greenfire.po.Result;
import com.needle.greenfire.po.TestCase;
import com.needle.greenfire.utils.Utils;

import java.lang.reflect.Method;
import java.util.List;

public class RunTestCase {
	public static ActionKeywords actionKeywords;
	public static Method[] method;
	public static String sActionKeyword;
	public static String sLocator;
	public static String sLocatorValue;
	public static int sTestCaseID;
	public static String sRunMode;
	public static String sData;
	public static boolean bResult;
	public static String imgPath;

	public RunTestCase() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
	}

	public static void executeTestCase() {
		Model model = new Model();
		List pList = model.findProjects();

		for (int i = 0; i < pList.size(); i++) {
			Project project = (Project) pList.get(i);
			int pid = project.getPid();

			List tcList = model.FindProCaseInfo(pid);
			for (int j = 0; j < tcList.size(); j++) {
				TestCase testCase = (TestCase) tcList.get(j);
				int tcid = testCase.getTcid();
				String runMode = testCase.getRunmode();
				if (!runMode.equals("Yes"))
					continue;
				List csList = model.FindCaseStepInfo(pid, tcid);
				for (int k = 0; k < csList.size(); k++) {
					CaseStep caseStep = (CaseStep) csList.get(k);
					sActionKeyword = caseStep.getKname();
					sLocator = caseStep.getLocator();
					sLocatorValue = caseStep.getLocatorValue();
					sData = caseStep.getStrValue();
					execute_Actions();
					Result result = new Result();
					result.setPid(pid);
					result.setTcid(tcid);
					result.setTsid(caseStep.getTsid());
					if (bResult) {
						result.setResults("PASS");
						result.setErrorimage("");
					} else {
						model.updateFailNum(pid);
						result.setResults("FAIL");
						result.setErrorimage(imgPath);
					}
					result.setRunTime(Utils
							.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
					model.addResult(result);
				}
			}
		}
	}

	private static void execute_Actions() {
		try {
			for (int i = 0; i < method.length; i++)
				if (method[i].getName().equals(sActionKeyword)) {
					method[i].invoke(sActionKeyword, new Object[] { sLocator,
							sLocatorValue, sData });
					if (bResult) {
						break;
					}
					ActionKeywords.CloseBrowser("", "", "");
					break;
				}
		} catch (Exception localException) {
		}
	}
}
