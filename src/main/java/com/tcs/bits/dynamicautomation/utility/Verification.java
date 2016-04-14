package com.tcs.bits.dynamicautomation.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public final class Verification {

	public static boolean isElementPresent(By by, WebDriver driver) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isErrorMessagePresent(String message, WebDriver driver) {
		try {
			driver.getPageSource().contains(message);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
}
