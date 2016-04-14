package com.tcs.bits.dynamicautomation.action;

import java.io.File;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.ui.Select;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tcs.bits.dynamicautomation.screenobjects.CreateScreenObjects;
import com.tcs.bits.dynamicautomation.to.Config;
import com.tcs.bits.dynamicautomation.to.DataSet;
import com.tcs.bits.dynamicautomation.to.Output;
import com.tcs.bits.dynamicautomation.utility.Actions;

import junit.framework.Assert;

public class Validation {

	public static Output StartVerification(List<DataSet> datasetArray, String browser, String URL, Config config) throws Exception {

		WebDriver driver = Actions.selectBrowser(browser, config);
		Output outputTO = new Output();
		driver.get(URL);
		Thread.sleep(3000);
		Logger logger = Logger.getLogger("App Log");

		// configure log4j properties file
		PropertyConfigurator.configure("Log4j.properties");

		File browserscreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(browserscreenshot, new File(config.getScreenshotsPath() +"\\OpenBrowser.jpeg"));
		logger.info("Launched Browser");

		int i = 0;
		int j = 0;
		for (DataSet dataSetTemp : datasetArray) {
			if (dataSetTemp.getObjectAction().equalsIgnoreCase("Verification")
					|| dataSetTemp.getObjectAction().equalsIgnoreCase("submit")
					|| dataSetTemp.getObjectAction().equalsIgnoreCase("check")) {
				i = i + 1;
			}
		}
		for (DataSet dataSetTemp : datasetArray) {
			   if (dataSetTemp.getObjectType().equalsIgnoreCase("Title")
			     && dataSetTemp.getObjectAction().equalsIgnoreCase("Verification"))
			   {
			    Assert.assertEquals(" title matched", dataSetTemp.getExpectedvalue().toString(),
			      driver.getTitle().toString());
			    System.out.println(" Title matches proceeding with other validations");
			    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(screenshot, new File(
			      config.getScreenshotsPath() +"\\Verify" + dataSetTemp.getExpectedvalue().toString() + ".jpeg"));
			    logger.info("Verified title" + dataSetTemp.getExpectedvalue().toString());
			    j = j + 1;
			   } else if (dataSetTemp.getObjectType().equalsIgnoreCase("link")
			     && dataSetTemp.getObjectAction().equalsIgnoreCase("click")) {
			    Validation.createElement(driver, dataSetTemp).click();
			    System.out.println("Link Clicked");
			    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(screenshot,
			      new File(config.getScreenshotsPath() +"\\link" + dataSetTemp.getObjectName() + ".jpeg"));
			    logger.info("clicked on link" + dataSetTemp.getObjectName());
			   } else if (dataSetTemp.getObjectType().equalsIgnoreCase("textbox")
			     && dataSetTemp.getObjectAction().equalsIgnoreCase("sendkeys")) {
			    Validation.createElement(driver, dataSetTemp).sendKeys(dataSetTemp.getObjectValue());
			    ;
			    System.out.println("Values passed to element");
			    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(screenshot,
			      new File(config.getScreenshotsPath() +"\\sendkeys" + dataSetTemp.getObjectName() + ".jpeg"));
			    logger.info("Entered values in text box " + dataSetTemp.getObjectName());
			   } else if (dataSetTemp.getObjectType().equalsIgnoreCase("button")
			     && dataSetTemp.getObjectAction().equalsIgnoreCase("submit")) {
			    Validation.createElement(driver, dataSetTemp).click();
			    Thread.sleep(3000);
			    Assert.assertTrue("Condition satisfied",
			      driver.getPageSource().contains(dataSetTemp.getExpectedvalue()));
			    System.out.println("Verification done");
			    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(screenshot,
			      new File(config.getScreenshotsPath() +"\\click" + dataSetTemp.getObjectName() + ".jpeg"));
			    logger.info("Clicked on submit " + dataSetTemp.getObjectName());
			    j = j + 1;
			   } else if (dataSetTemp.getObjectType().equalsIgnoreCase("checkbox")
			     && dataSetTemp.getObjectAction().equalsIgnoreCase("check")) {
			    Validation.createElement(driver, dataSetTemp).click();
			    Thread.sleep(3000);
			    Assert.assertTrue("Check box checked", Validation.createElement(driver, dataSetTemp).isSelected());
			    System.out.println("Check box verified ");
			    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(screenshot,
			      new File(config.getScreenshotsPath() +"\\checkboxchecked" + dataSetTemp.getObjectName() + ".jpeg"));
			    logger.info("checkbox checked " + dataSetTemp.getObjectName());
			    j = j + 1;
			   } else if (dataSetTemp.getObjectType().equalsIgnoreCase("dropdown")
			     && dataSetTemp.getObjectAction().equalsIgnoreCase("select")) {
			    Validation.createElementDropdown(driver, dataSetTemp).selectByVisibleText(dataSetTemp.getObjectValue());
			    Thread.sleep(3000);
			    System.out.println("Check box verified ");
			    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(screenshot,
			      new File(config.getScreenshotsPath() +"\\checkboxchecked" + dataSetTemp.getObjectName() + ".jpeg"));
			    logger.info("value selected from drop down  " + dataSetTemp.getObjectValue());
			   } else if (dataSetTemp.getObjectType().equalsIgnoreCase("radiobutton")
			     && dataSetTemp.getObjectAction().equalsIgnoreCase("click")) {
			    Validation.createElement(driver, dataSetTemp).click();
			    Thread.sleep(3000);
			    System.out.println("radio button clicked ");
			    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(screenshot, new File(
			      config.getScreenshotsPath() +"\\RadioButtonclicked" + dataSetTemp.getObjectName() + ".jpeg"));
			    logger.info("Radio button clicked " + dataSetTemp.getObjectValue());
			   } else
			    System.exit(0);
			   Thread.sleep(3000);
			  }
		
		outputTO.setTotalTestCases(Integer.toString(i));
		outputTO.setPassCount(Integer.toString(j));
		outputTO.setFailCount(Integer.toString(i-j));
		outputTO.setLogsPath(config.getLogsPath());
		outputTO.setScreenshotsPath(config.getScreenshotsPath());
		
		logger.info("Total verification  count " + i);
		logger.info("Total pass  count " + j);
		logger.info("Total fail   count " + (i - j));
		// VerificationModule.verifyPageTitle(datasetArray, driver);
		driver.close();
		
		return outputTO;
	}

	public static WebElement createElement(WebDriver driver, DataSet dataset) {
		if (dataset.getObjectIdentification().equalsIgnoreCase("id")) {
			return CreateScreenObjects.createwebelementbyid(dataset.getObjectName(), driver);
		}
		if (dataset.getObjectIdentification().equalsIgnoreCase("name")) {
			return CreateScreenObjects.createwebelementbyname(dataset.getObjectName(), driver);
		}
		if (dataset.getObjectIdentification().equalsIgnoreCase("linktext")) {
			return CreateScreenObjects.createwebelementbylink(dataset.getObjectName(), driver);
		} else {

			/// todo code
			return null;
		}
	}

	public static Select createElementDropdown(WebDriver driver, DataSet dataset) {
		if (dataset.getObjectIdentification().equalsIgnoreCase("id")) {
			return CreateScreenObjects.createDropDownbyID(dataset.getObjectName(), driver);
		}
		if (dataset.getObjectIdentification().equalsIgnoreCase("name")) {
			return CreateScreenObjects.createDropDownbyname(dataset.getObjectName(), driver);
		}
		if (dataset.getObjectIdentification().equalsIgnoreCase("linktext")) {
			return CreateScreenObjects.createDropDownbyxpath(dataset.getObjectName(), driver);
		} else {

			/// todo code
			return null;
		}
	}

}
