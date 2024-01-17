package com.project.Dataprovider;

import org.testng.annotations.DataProvider;

public class GetData {

	
	@DataProvider(name="TestingData")
	public static Object[][] GetDataExcel()
	{
		Object[][] arr=ExcelClass.GetExcelData("Login");
		
		return arr;
		
	}
}
