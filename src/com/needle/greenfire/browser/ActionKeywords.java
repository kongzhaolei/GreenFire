package com.needle.greenfire.browser;

import com.needle.greenfire.utils.Logs;
import com.needle.greenfire.utils.Utils;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionKeywords {
	private static WebDriver driver;
	private static Actions actions;

	public static void OpenBrowser(String locator, String locatorValue,
			String data) {
		if (!Utils.isNull(data)) {
			String[] strPara = data.split(";");

			if (strPara.length == 1) {
				Logs.info("Open Local WebDriver Browser Type " + data);
				driver = DriverFactory.getInstance().getLocalDriver(data);
			} else if (strPara.length == 2) {
				Logs.info("Open Remote WebDriver Browser Type " + strPara[0]
						+ " to Remote URL " + strPara[1]);
				driver = DriverFactory.getInstance().getRemoteDriver(
						strPara[0], strPara[1]);
			} else {
				com.needle.greenfire.engine.RunTestCase.bResult = false;
			}
			actions = new Actions(driver);
		} else {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.warn("Not input Open Browser type value.");
		}
	}

	public static void MaxBrowser(String locator, String locatorValue,
			String data) {
		try {
			Logs.info("WebDriver max Browser .");
			driver.manage().window().maximize();
		} catch (Exception e) {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.error("WebDriver Not  max Browser  ." + e.getMessage());
		}
	}

	public static void Navigate(String locator, String locatorValue, String data) {
		if (!Utils.isNull(data)) {
			try {
				Logs.info("WebDriver Browser Navigate.");
				driver.navigate().to(data);
			} catch (Exception e) {
				com.needle.greenfire.engine.RunTestCase.bResult = false;
				Logs.error("WebDriver Not Browser Navigate to URL:" + data
						+ " ." + e.getMessage());
			}
		} else {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.warn("Not input Navigate URL value.");
		}
	}

	public static void Refresh(String locator, String locatorValue, String data) {
		try {
			Logs.info("WebDriver Browser Refresh.");
			driver.navigate().refresh();
		} catch (Exception e) {
			Logs.error("WebDriver Not Browser Refresh ." + e.getMessage());
		}
	}

	public static void Forward(String locator, String locatorValue, String data) {
		try {
			Logs.info("WebDriver Browser Forward.");
			driver.navigate().forward();
		} catch (Exception e) {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.error("WebDriver Not Browser Forward ." + e.getMessage());
		}
	}

	public static void Back(String locator, String locatorValue, String data) {
		try {
			Logs.info("WebDriver Browser Back.");
			driver.navigate().back();
		} catch (Exception e) {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.error("WebDriver Not Browser Back ." + e.getMessage());
		}
	}

	public static void CloseBrowser(String locator, String locatorValue,
			String data) {
		try {
			if (driver != null) {
				Logs.info("WebDriver Close Browser .");
				driver.close();
				driver.quit();
			} else {
				Utils.CloseProcess();
				Logs.info("Close 'iexplore.exe'銆�'IEDriverServer.exe'銆�'chrome.exe'銆�'chromedriver.exe'銆�'firefox.exe'銆�'safari.exe'銆�'opera.exe' Browser .");
			}
		} catch (Exception e) {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.error("WebDriver Not Close Browser ." + e.getMessage());
		}
	}

	public static void Click(String locator, String locatorValue, String data) {
		if ((!Utils.isNull(locator)) && (!Utils.isNull(locatorValue))) {
			try {
				Logs.info("Click page Element By '" + locator + "' info '"
						+ locatorValue);
				WebElement element = Utils.findElement(driver, locator,
						locatorValue);
				Utils.highlightElement(driver, element);
				element.click();
			} catch (Exception e) {
				com.needle.greenfire.engine.RunTestCase.bResult = false;
				Logs.error("Not Click page Element By '" + locator + "' info '"
						+ locatorValue + " , " + e.getMessage());
			}
		} else {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.warn("Not input Click Page Object Element.");
		}
	}

	public static void Input(String locator, String locatorValue, String data) {
		if ((!Utils.isNull(locator)) && (!Utils.isNull(locatorValue))) {
			try {
				Logs.info("Input page Element By '" + locator + "' info '"
						+ locatorValue + "' value :" + data);
				WebElement element = Utils.findElement(driver, locator,
						locatorValue);
				Utils.highlightElement(driver, element);
				element.sendKeys(new CharSequence[] { data });
			} catch (Exception e) {
				com.needle.greenfire.engine.RunTestCase.bResult = false;
				Logs.error("Not Input page Element By '" + locator + "' info '"
						+ locatorValue + " value :" + data + " ,"
						+ e.getMessage());
			}
		} else {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.warn("Not input Page Object Element and value.");
		}
	}

	public static void assertExistElement(String locator, String locatorValue,
			String data) {
		if ((!Utils.isNull(locator)) && (!Utils.isNull(locatorValue))) {
			try {
				Logs.info("assertExistElement : mouseMoveTo Element By '"
						+ locator + "' info '" + locatorValue + "' .");
				WebElement element = Utils.findElement(driver, locator,
						locatorValue);
				Utils.highlightElement(driver, element);
			} catch (NoSuchElementException e) {
				com.needle.greenfire.engine.RunTestCase.bResult = false;
				Logs.error("assertExistElement : Not assertExistElement Element By '"
						+ locator
						+ "' info '"
						+ locatorValue
						+ "' . "
						+ e.getMessage());
			}
		} else {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.warn("assertExistElement : Not input assertExistElement is Page Object Element null.");
		}
	}

	public static void assertURL(String locator, String locatorValue,
			String data) {
		if (!Utils.isNull(data)) {
			if (data.equals(driver.getCurrentUrl())) {
				Logs.info("assertURL expected value : " + data
						+ " , actual value : " + driver.getCurrentUrl()
						+ " consistent.");
			} else {
				com.needle.greenfire.engine.RunTestCase.bResult = false;
				Logs.error("assertURL expected value : " + data
						+ " , actual value : " + driver.getCurrentUrl()
						+ " Not consistent.");
			}
		} else {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.warn("Not input URL expected value.");
		}
	}

	public static void assertTitle(String locator, String locatorValue,
			String data) {
		if (!Utils.isNull(data)) {
			if (data.equals(driver.getTitle())) {
				Logs.info("assertTitle expected value : " + data
						+ " , actual value : " + driver.getTitle()
						+ " consistent.");
			} else {
				com.needle.greenfire.engine.RunTestCase.bResult = false;
				Logs.error("assertTitle expected value : " + data
						+ " , actual value : " + driver.getTitle()
						+ " Not consistent.");
			}
		} else {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.warn("Not input Tilte expected value.");
		}
	}

	public static void assertText(String locator, String locatorValue,
			String data) {
		if ((!Utils.isNull(data)) && (!Utils.isNull(locator))
				&& (!Utils.isNull(locatorValue))) {
			WebElement element = Utils.findElement(driver, locator,
					locatorValue);
			if (data.equals(element.getText())) {
				Logs.info("assertText expected value : " + data
						+ " , actual value : " + element.getText()
						+ " consistent.");
			} else {
				com.needle.greenfire.engine.RunTestCase.bResult = false;
				Logs.error("assertText expected value : " + data
						+ " , actual value : " + element.getText()
						+ " Not consistent.");
			}
		} else {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.warn("Not input Page Object Element and Text expected value.");
		}
	}

	public static void Sleep(String locator, String locatorValue, String data) {
		if (!Utils.isNull(data)) {
			try {
				Logs.info("Sleep " + data + " SECONDS");
				TimeUnit.SECONDS.sleep(Integer.parseInt(data));
			} catch (Exception e) {
				com.needle.greenfire.engine.RunTestCase.bResult = false;
				Logs.error("Not Sleep " + data + "SECONDS." + e.getMessage());
			}
		} else {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.warn("Not input sleep SECONDS.");
		}
	}

	public static void Menu(String locator, String locatorValue, String data) {
	}

	public static void RunJavaScript(String locator, String locatorValue,
			String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (!Utils.isNull(data))
			js.executeScript(data, new Object[0]);
	}

	public static void mouseMoveTo(String locator, String locatorValue,
			String data) {
		if ((!Utils.isNull(locator)) && (!Utils.isNull(locatorValue))) {
			try {
				Logs.info("mouseMoveTo : mouseMoveTo Element By '" + locator
						+ "' info '" + locatorValue + "' .");
				WebElement element = Utils.findElement(driver, locator,
						locatorValue);
				Utils.highlightElement(driver, element);
				actions.moveToElement(element).perform();
			} catch (Exception e) {
				com.needle.greenfire.engine.RunTestCase.bResult = false;
				Logs.error("mouseMoveTo : Not mouseMoveTo Element By '"
						+ locator + "' info '" + locatorValue + "' . "
						+ e.getMessage());
			}
		} else {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.warn("mouseMoveTo : Not input mouseMoveTo Page Object Element is null.");
		}
	}

	public static void switchToFrame(String locator, String locatorValue,
			String data) {
		if ((!Utils.isNull(locator)) && (!Utils.isNull(locatorValue))) {
			try {
				Logs.info("switchToFrame : switchToFrame Element By '"
						+ locator + "' info '" + locatorValue + "' .");
				driver.switchTo().frame(
						Utils.findElement(driver, locator, locatorValue));
			} catch (Exception e) {
				com.needle.greenfire.engine.RunTestCase.bResult = false;
				Logs.error("switchToFrame : Not switchToFrame By '" + locator
						+ "' info '" + locatorValue + "' . " + e.getMessage());
			}
		} else {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.warn("switchToFrame : Not input mouseMoveTo Page Object Element is null.");
		}
	}

	public static void switchToWindow(String locator, String locatorValue,
			String data) {
		if (!Utils.isNull(data)) {
			try {
				String currentHandle = driver.getWindowHandle();
				Set<String> handles = driver.getWindowHandles();
				for (String str : handles) {
					if (str.equals(currentHandle)) {
						continue;
					}
					driver.switchTo().window(str);
					if (driver.getTitle().contains(data)) {
						Logs.info("switchToWindow : switchToWindow Page Title in '"
								+ data + "' .");
						break;
					}
				}

			} catch (Exception e) {
				com.needle.greenfire.engine.RunTestCase.bResult = false;
				Logs.error("switchToWindow : Window : '" + data
						+ "' cound not found! " + e.getMessage());
			}
		} else {
			com.needle.greenfire.engine.RunTestCase.bResult = false;
			Logs.warn("switchToWindow : Not input switchToWindow Page Title.");
		}
	}
}
