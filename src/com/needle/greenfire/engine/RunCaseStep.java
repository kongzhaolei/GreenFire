package com.needle.greenfire.engine;

import com.needle.greenfire.browser.ActionKeywords;

import java.lang.reflect.Method;

public class RunCaseStep {
	public static ActionKeywords actionKeywords;
	public static Method[] method;

	public RunCaseStep() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
	}

	public static void executeTestCaseStep(String keyName, String sLocator,
			String sLocatorValue, String sData) {
		try {
			for (int i = 0; i < method.length; i++)
				if (method[i].getName().equals(keyName))
					method[i].invoke(keyName, new Object[] { sLocator,
							sLocatorValue, sData });
		} catch (Exception localException) {
		}
	}
}