package com.project.TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.Base.BaseClass;
import com.project.Dataprovider.GetData;
import com.project.pages.LoginPage;

public class LoginTestCase extends BaseClass{

	
	@Test(dataProvider="TestingData",dataProviderClass=GetData.class)
	public void Login(String phonenumber)
	{
		
		LoginPage page=new LoginPage(driver);
		Assert.assertTrue(page.isLogoDisplayed());
		page.LoginP(phonenumber);
		//Assert.assertTrue(page.verifyOTPtext());
		
	}
	
	
}
