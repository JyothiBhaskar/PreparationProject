package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.project.Utility.Helper;

public class LoginPage {

	
	protected WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By Loginlink=By.xpath("//a[@title='Login']//span");
	private By EnterMobilenumber=By.xpath("//span[text()='Enter Email/Mobile number']/../../input[@type='text']");
	private By OTPbutton=By.xpath("//button[text()='Request OTP']");	
	private By otptext=By.xpath("//div[text()='Please enter the OTP sent to']");	
	private By FLogo=By.xpath("//img[@title='Flipkart']");
	
	
	
	public boolean isLogoDisplayed()
	{
		 return Helper.WebdriverWait(driver, FLogo).isDisplayed();
	}
	
	
		public void LoginP(String phonenumber)
	{
		 
		  Helper.WebdriverWait(driver, Loginlink).click();
		  Helper.WebdriverWait(driver, EnterMobilenumber).sendKeys(phonenumber); 
		  Helper.WebdriverWait(driver, OTPbutton).click();
	}
	
		public boolean verifyOTPtext()
	{
		return Helper.WebdriverWait(driver, otptext).isDisplayed();
		//driver.findElement(otptext).getText();
	}
		



}
