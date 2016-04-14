package com.tcs.bits.dynamicautomation.screenobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

// this class is to create screenobjects dynamically based on input sheet.
public final class CreateScreenObjects {

	public static WebElement createwebelementbyid(String object, WebDriver driver) {
		return driver.findElement(By.id(object));
	}

	public static WebElement createwebelementbyname(String object, WebDriver driver) {
		return driver.findElement(By.name(object));
	}

	public static WebElement createwebelementbylink(String object, WebDriver driver) {
		return driver.findElement(By.linkText(object));
	}

	public static WebElement createwebelementbyxpath(String object, WebDriver driver) {
		return driver.findElement(By.xpath(object));
	}

	public static Select createDropDownbyID(String object, WebDriver driver) {
		return new Select(driver.findElement(By.id(object)));
	}

	public static Select createDropDownbyname(String object, WebDriver driver) {
		return new Select(driver.findElement(By.name(object)));
	}

	public static Select createDropDownbyxpath(String object, WebDriver driver) {
		return new Select(driver.findElement(By.xpath(object)));
	}

}
