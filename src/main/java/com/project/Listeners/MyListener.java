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

public class MyListener implements ITestListener
{

	ExtentReports report=ExtentReport.getInstance();
	ExtentTest extenttest;
	
	public void onTestSuccess(ITestResult result)
	{
		WebDriver driver=Browsefactory.getDriver();
		String takescreenshot=Helper.Takescreenshot(driver);
		if(ConfigClass.getProperty("screenshotOnSuccess").equalsIgnoreCase("true"))
		{
			extenttest.pass("test pass",MediaEntityBuilder.createScreenCaptureFromBase64String(takescreenshot).build());
		}
		extenttest.pass("test pass");
	}
	
	public void onTestFailure(ITestResult result)
	{
		WebDriver driver=Browsefactory.getDriver();
		String takescreenshot=Helper.Takescreenshot(driver);
		extenttest.fail("Test Fail"+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(takescreenshot).build());
	}
	
	public void onTestSkipped(ITestResult result)
	{
	extenttest.skip("On test skip"+result.getThrowable().getMessage());
}
	public void onTestStart(ITestResult result)
	{
	extenttest =report.createTest("creating test"+result.getMethod().getMethodName());

	}
	public void onFinish(ITestContext context)
	{
		report.flush();
	}
	}