package com.project.Base;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.BrowseFactory.Browsefactory;
import com.project.Dataprovider.ConfigClass;

public class BaseClass {

	public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		Reporter.log("Log Info: Setting upthe Browser", true);
		driver=Browsefactory.getBrowser(ConfigClass.getProperty("BrowserName"), ConfigClass.getProperty("appURL"));
		Reporter.log("Log Info: Browser and Application is up and running", true);
	}
	
	@AfterMethod
	public void teardown()
	{
		Reporter.log("Closing the Browser");
		Browsefactory.CloseBrowser(driver);
		Reporter.log("Log Info:Browser Closed");
	}
}
