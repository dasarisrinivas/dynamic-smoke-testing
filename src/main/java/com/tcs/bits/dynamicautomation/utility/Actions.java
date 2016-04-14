package com.tcs.bits.dynamicautomation.utility;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.tcs.bits.dynamicautomation.to.Config;

import junit.framework.Assert;

public class Actions {

	public static void SendKeysAction(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void submitAction(WebElement element) {
		element.submit();
	}

	public static boolean verificationisDisplayed(WebElement element) {
		return element.isDisplayed();

	}

	public static void assertEqualsmethod(String expected, String actual) {
		Assert.assertEquals(expected, actual);

	}

	public static void asserttruemethod(boolean result) {
		Assert.assertTrue(result);

	}

	public static WebDriver selectBrowser(String browser, Config config)

	{
		if (browser.equalsIgnoreCase("Chrome")) {
			File file = new File(config.getChromeDriverPath());
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			WebDriver driver = new ChromeDriver();
			return driver;
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriver driver = new FirefoxDriver();
			return driver;
		} else {
			File file = new File(config.getIeDriverPath());
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			WebDriver driver = new InternetExplorerDriver();
			return driver;
		}
	}

	public static void clickAction(WebElement element) {
		element.click();
	}

}
