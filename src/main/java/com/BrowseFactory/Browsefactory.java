package com.BrowseFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import com.project.Dataprovider.ConfigClass;

public class Browsefactory {

	
	public static WebDriver driver;
	
public static WebDriver getDriver() {
		
		return driver;
	}
	
	
	public static WebDriver getBrowser(String BrowserName, String appURL)
	{
		if (BrowserName.equalsIgnoreCase("chrome")||BrowserName.equalsIgnoreCase("Google Chrome")) 
		{
			ChromeOptions options=new ChromeOptions();
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability("browserName", "chrome");
			capabilities.setCapability("browserVersion", "120.0");
			capabilities.setCapability("platformName", "linux");
			
			if (ConfigClass.getProperty("headless").equalsIgnoreCase("true")) 
			{
				options.addArguments("--headless=new");
				
			Reporter.log("LOG:INFO - Running Test In Headless Mode",true);

			}
			options.merge(capabilities);
			
			try {
				driver=new RemoteWebDriver(new URL("http://13.201.23.213:4444/"),options);
			} catch (MalformedURLException e) {
			Reporter.log("Log Info - Remote webdriver not launched" +e.getMessage());
			}
			
			
			//driver=new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Firefox")||BrowserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Edge")||BrowserName.equalsIgnoreCase("edge"))
		{
			EdgeOptions edgeOptions=new EdgeOptions();
			edgeOptions.addArguments("--guest");
			
			driver=new EdgeDriver(edgeOptions);		}
		else
		{
			Reporter.log("Log Info : We run only on Chrome,Firefox and Edge BRowsers");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
		
	}
	
	public static void CloseBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
