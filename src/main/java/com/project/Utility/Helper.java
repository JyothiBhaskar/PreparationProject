package com.project.Utility;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.project.Dataprovider.ConfigClass;

public class Helper {

	/*
	 * 	
	 * waits - completed
	 * scroll - completed
	 * screenshot-completed
	 * highlighter - completed
	 * actions - completed
	 * click and sendKeys - Completed
	 * switch - completed
	 * javascript - completed
	 * select - completed
	 * WindowHandles-completed
	
	/* complete this utility with below methods
	 * 	
	 * 		doubleclick
	 * 		rightclick
	 * 		dragDrop
	 * 		mouseHover
	 *
	 */
	
	public static void WindowHandles(WebDriver driver)
	{
		String parentwindow=driver.getWindowHandle();
		System.out.println(driver.getWindowHandle());
		
		Set<String> s=driver.getWindowHandles();
		Iterator<String> it=s.iterator();
		while(it.hasNext())
		{
			String ChildWindow=it.next();
			driver.switchTo().window(ChildWindow);
			System.out.println(driver.switchTo().window(ChildWindow).getTitle());
			driver.close();
		}
		driver.switchTo().window(parentwindow);
	}
	
	  public static void Switchmethod(WebDriver driver,WebElement ele)
	{
		driver.switchTo().frame(Helper.ClickMethod(driver, ele));
	}
	
	public static void selectmethod(WebDriver driver, WebElement ele,String valuetoselect) 
	{
		Select sel=new Select(Helper.ClickMethod(driver, ele));
		sel.selectByValue(valuetoselect);
	}
	public static void SelectbyVisibletext(WebDriver driver, WebElement ele,String Visibletext)
	{		
		Select sel=new Select(Helper.ClickMethod(driver, ele));
		sel.selectByVisibleText(Visibletext);
		
	}
	
	public static void ScrollToElement(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(ele).perform();
	}
	
	public static void ScrolltoElement(WebDriver driver,By Locator)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(driver.findElement(Locator)).perform();
	}
	
	public static void MouseHover(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		
	}
	public static void doubleclick(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	public static void dragdrop(WebDriver driver,WebElement ele,By Locator)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(ele).moveToElement(driver.findElement(Locator)).build().perform();
	}
	public static void rightclick()
	{
		
	}
	public static WebElement Highlighter(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: solid 2px red')", ele);
				
		SleepMethod(2);
		
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px black')", ele);

		return ele;
	}
	
	public static String Takescreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String value=ts.getScreenshotAs(OutputType.BASE64);
		
		return value;	
		
	}
	
	public static void SleepMethod(int TimeinSeconds)
	{
		
	  try {
		Thread.sleep(TimeinSeconds*1000);
	} catch (InterruptedException e) {
		
		Reporter.log("Log Info - Thread interupted" + e.getMessage());
	}
	}
	
	public static WebElement WebdriverWait(WebDriver driver,By Locator) 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(Locator));
		String highlight=ConfigClass.getProperty("HighElement");
		
		if(highlight.equalsIgnoreCase("true"))
		{
			Helper.Highlighter(driver, ele);
		}
		return ele;
		
	}
	
	public static WebElement ClickMethod(WebDriver driver,WebElement ele)
	{
		try {
			
         ele.click();
		
		} catch (Exception e) {
		
		Reporter.log("Log Info : Click method faile - Trying with Action class Click" +e.getMessage());
		Actions act=new Actions(driver);
		try {
			act.click().perform();
		} catch (Exception e1) {
			Reporter.log("Log Info:Actions class clic failed - Trying with JavaScript Executor"+e.getMessage());
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click",ele);
			}
		}
		return ele;		
		
		
	}
	
	
}
