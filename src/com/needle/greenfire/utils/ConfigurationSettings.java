package com.needle.greenfire.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationSettings {
	private static Properties props = null;
	private static final String SELENIUM_CONFIG = System
			.getProperty("user.dir") + "\\src\\" + "selenium.properties";
	public static final String SELENIUM_DRIVER = "SELENIUM_DRIVER";
	public static final String WEBDRIVER_CHROME_DRIVER_PATH;
	public static final String WEBDRIVER_IE_DRIVER_PATH;
	public static final String SCREENSHOT_ERROR_PATH;
	public static final String SCREENSHOT_AUTO_PATH;

	static {
		try {
			InputStream in = null;
			props = new Properties();
			File file = new File(SELENIUM_CONFIG);
			if ((file.exists()) && (!file.isDirectory())) {
				in = new FileInputStream(file);
			}
			props.load(in);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File not found Exception", e);
		} catch (Exception e) {
			throw new RuntimeException(
					"ConfigurationSettings initializi failed.", e);
		}

		WEBDRIVER_CHROME_DRIVER_PATH = System.getProperty("user.dir")
				+ getProperty("webdriver.chrome.driver.path").trim();
		WEBDRIVER_IE_DRIVER_PATH = System.getProperty("user.dir")
				+ getProperty("webdriver.ie.driver.path").trim();

		SCREENSHOT_ERROR_PATH = System.getProperty("user.dir")
				+ getProperty("screenshot.error.path").trim();
		SCREENSHOT_AUTO_PATH = System.getProperty("user.dir")
				+ getProperty("screenshot.auto.path").trim();
	}

	public static String getProperty(String PropertyName) {
		return props.getProperty(PropertyName);
	}
}
