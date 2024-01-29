package com.project.Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BrowseFactory.Browsefactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.project.Dataprovider.ConfigClass;
import com.project.Utility.Helper;

public class Listener implements ITestListener{
	
	
   ExtentReports reports=Extent.getinstance();
   ExtentTest extent;
   
   
   
   public void onTestSuccess(ITestResult result)
   {
	   WebDriver driver=Browsefactory.getDriver();
	   String Screenshot=Helper.Takescreenshot(driver);
	   if(ConfigClass.getProperty("screenshotOnSuccess").equalsIgnoreCase("true"))
	   {
	  extent.pass("Test Passed"+MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot).build());  
	   
   }
	   extent.pass("Test Passed");
   }
   public void onTestFailure(ITestResult result)
   {
	   extent.fail("Test failed" + result.getTestName());
   }
   
   public void onTestSkipped(ITestResult result)
   {   
	   extent.skip("Test Skipped"+result.getThrowable().getMessage());
   }
   public void onTestStart(ITestResult result)
   {
	   extent=reports.createTest("Test started"+result.getMethod().getMethodName());
   }
   
  public void onFinish(ITestContext context)
  {
	  reports.flush();
  }
   

}
