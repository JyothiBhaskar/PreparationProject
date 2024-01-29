package com.project.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent {

	private static ExtentReports extentreporter;
	
	public static ExtentReports getinstance()
	{
		if(extentreporter==null)
	
		{
			CreateInstance();
		}
		return extentreporter;
	}
	
	public static ExtentReports CreateInstance()
	{
		ExtentSparkReporter reporter=new ExtentSparkReporter("./ExtentReports");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Sprint 1");
		reporter.config().setTheme(Theme.DARK);
		extentreporter =new ExtentReports();
		extentreporter.attachReporter(reporter);
		return extentreporter;
		
	}
	
	
}
