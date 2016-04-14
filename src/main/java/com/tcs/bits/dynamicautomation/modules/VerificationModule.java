package com.tcs.bits.dynamicautomation.modules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tcs.bits.dynamicautomation.to.DataSet;

public class VerificationModule {
	
	
	
	
	public static void verifyPageTitle(List<DataSet> datasetArray,WebDriver driver) throws Exception
	{
         String actualTitle = driver.getTitle();
         String expectedTitle = null;
         
         for (DataSet dataSetTemp : datasetArray) {
        	 
        	 if(dataSetTemp.getObjectType().equalsIgnoreCase("pageTitle"))
        		 
        	 {	 
            	 expectedTitle = dataSetTemp.getObjectValue();
    		
             if(actualTitle.equalsIgnoreCase(expectedTitle))
            	 System.out.println(" Title matches proceeding with other validations");
             else
            	System.exit(0);
        	 
        	 }
 		}
         
         VerificationModule.click(datasetArray, driver);
         
	}
	
	public static void click(List<DataSet> datasetArray, WebDriver driver) throws Exception
	{
		
   		Thread.sleep(2000);
		 for (DataSet dataSetTemp : datasetArray) {
			 
              if(dataSetTemp.getObjectAction().equalsIgnoreCase("click"))
        		
        	 {
            	  WebElement createnewuser= driver.findElement(By.linkText(dataSetTemp.getObjectValue()));
                  createnewuser.click();
            	  
        	 }
			 
		 }
        
	}


}
