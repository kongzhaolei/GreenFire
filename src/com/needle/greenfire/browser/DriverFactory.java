package com.needle.greenfire.browser;

import com.needle.greenfire.utils.Utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	private static DriverFactory instance = null;

	static {
		instance = new DriverFactory();
	}

	public static DriverFactory getInstance() {
		return instance;
	}

	public WebDriver getLocalDriver(String broType) {
		LocalDriver localDriver = null;
		try {
			localDriver = (LocalDriver) Enum.valueOf(LocalDriver.class,
					checkBrowserType(broType));
		} catch (Exception localException) {
		}
		return localDriver.getDriver();
	}

	public WebDriver getRemoteDriver(String broType, String strUrl) {
		RemoteDriver remoteDriver = null;
		try {
			remoteDriver = (RemoteDriver) Enum.valueOf(RemoteDriver.class,
					checkBrowserType(broType));
		} catch (Exception localException) {
		}
		return remoteDriver.getDriver(strUrl);
	}

	private String checkBrowserType(String broType) {
		String strType = "";
		if (!Utils.isNull(broType)) {
			switch ((broType.toUpperCase()).hashCode()) {
			case -1856568448:
				strType = "Safari";
				break;
			case -131469639:
				strType = "FireFox";
				break;
			case 2332:
				strType = "InternetExplorer";
				break;
			case 75410355:
				strType = "Opera";
				break;
			case 1987167866:
				strType = "Chrome";
				break;
			}
		}
		return strType;
	}
}
