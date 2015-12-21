package com.needle.greenfire.utils;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.misc.BASE64Encoder;

public class Utils {
	public static String getCurrentDate(String DateFormat) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
		return sdf.format(date);
	}

	public static String md5Encryption(String strValue) {
		String newStr = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base = new BASE64Encoder();
			newStr = base.encode(md5.digest(strValue.getBytes("UTF-8")));
		} catch (Exception localException) {
		}
		return newStr;
	}

	public static boolean isNull(String strValue) {
		return (strValue == null) || (strValue.trim().equals(""));
	}

	public static boolean isNumeric(String strValue) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(strValue);

		return isNum.matches();
	}

	public static WebElement findElement(WebDriver driver, String Type,
			String strPro) {
		WebElement element = null;
		try {
			switch ((Type.toUpperCase()).hashCode()) {
			case -1581952061:
				element = driver.findElement(By.className(strPro));
				break;
			case -1283041598:
				element = driver.findElement(By.cssSelector(strPro));
				break;
			case -830248699:
				element = driver.findElement(By.tagName(strPro));
				break;
			case 2331:
				element = driver.findElement(By.id(strPro));
				break;
			case 2388619:
				element = driver.findElement(By.name(strPro));
				break;
			case 83718269:
				element = driver.findElement(By.xpath(strPro));
				break;
			case 1345567880:
				element = driver.findElement(By.partialLinkText(strPro));
				break;
			case 19777679:
				element = driver.findElement(By.linkText(strPro));
				break;
				} 
			}catch(Exception e){
				e.printStackTrace();
			}
          return element;
	}

	public static List<WebElement> findElements(WebDriver driver, String Type,
			String strPro) {
		List elements = null;
		try {
			switch ((Type.toUpperCase()).hashCode()) {
			case -1581952061:
				elements = driver.findElements(By.className(strPro));
				break;
			case -1283041598:
				elements = driver.findElements(By.cssSelector(strPro));
				break;
			case -830248699:
				elements = driver.findElements(By.tagName(strPro));
				break;
			case 2331:
				elements = driver.findElements(By.id(strPro));
				break;
			case 2388619:
				elements = driver.findElements(By.name(strPro));
				break;
			case 83718269:
				elements = driver.findElements(By.xpath(strPro));
				break;
			case 1345567880:
				elements = driver.findElements(By.partialLinkText(strPro));
				break;
			case 19777679:
				elements = driver.findElements(By.linkText(strPro));
				break;
				} 
			}catch(Exception e){
				e.printStackTrace();
			}
		return elements;
	}

	public static void CloseProcess() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("TASKKILL /F /IM iexplore.exe");
			runtime.exec("TASKKILL /F /IM IEDriverServer.exe");
			runtime.exec("TASKKILL /F /IM chrome.exe");
			runtime.exec("TASKKILL /F /IM chromedriver.exe");
			runtime.exec("TASKKILL /F /IM firefox.exe");
			runtime.exec("TASKKILL /F /IM safari.exe");
			runtime.exec("TASKKILL /F /IM opera.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String screenShots(WebDriver driver) {
		File screenShotFile = (File) ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String imgPath = ConfigurationSettings.SCREENSHOT_ERROR_PATH + "/"
				+ getCurrentDate("yyyyMMdd") + "/"
				+ getCurrentDate("yyyyMMddHms") + ".png";
		try {
			FileUtils.copyFile(screenShotFile,
					new File(System.getProperty("user.dir") + "/WebRoot/"
							+ imgPath));
		} catch (Exception localException) {
		}
		return imgPath;
	}

	public static void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"element = arguments[0];original_style = element.getAttribute('style');element.setAttribute('style', original_style + \";background: yellow; border: 2px solid red;\");setTimeout(function(){element.setAttribute('style', original_style);}, 1000);",
				new Object[] { element });
	}
}
