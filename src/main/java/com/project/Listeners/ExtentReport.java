package com.project.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if (extent == null)
    		CreateInstance();
		
		return extent;
		
	}
	
	public static ExtentReports CreateInstance()
	{
		ExtentSparkReporter reporter=new ExtentSparkReporter("./PreparationProject/ExtentReports");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Sprint 1");
		reporter.config().setTheme(Theme.DARK);		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
