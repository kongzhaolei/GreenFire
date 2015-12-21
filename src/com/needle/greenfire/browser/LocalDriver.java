package com.needle.greenfire.browser;

import com.needle.greenfire.utils.ConfigurationSettings;
import com.opera.core.systems.OperaDriver;

import jodd.util.StringUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public enum LocalDriver {
	InternetExplorer,
	FireFox,
	Chrome,
	Safari,
	Opera;

	public WebDriver getDriver(){
		WebDriver webdriver = null;
		
		
		return webdriver;
		
	}
}

