package com.project.Dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ExcelClass {

	
	public static Object[][] GetExcelData(String SheetName)
	{
		XSSFWorkbook wb=null;
					
		try {
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/PreparationprojectData.xlsx")));
		} catch (FileNotFoundException e) {
			Reporter.log("LogInfo - File not found" +e.getMessage());
		} catch (IOException e) {
			Reporter.log("Log Info- Couldnt Load the file"+e.getMessage());
		}
		
		int rowcount=wb.getSheet(SheetName).getPhysicalNumberOfRows();
		int colcount=wb.getSheet(SheetName).getRow(0).getPhysicalNumberOfCells();
		
		Object[][] arr=new Object[rowcount][colcount];
		
		for(int i=0;i<rowcount;i++)
		{
			
			for(int j=0;j<colcount;j++)
			{
				String Value="";
				CellType type=wb.getSheet(SheetName).getRow(i).getCell(j).getCellType();
				if(type==CellType.STRING)
				{
					Value= wb.getSheet(SheetName).getRow(i).getCell(j).getStringCellValue();
				}
				else if (type==CellType.BOOLEAN) 
				{
					boolean booleanValue=wb.getSheet(SheetName).getRow(i).getCell(j).getBooleanCellValue();
					Value=String.valueOf(booleanValue);
			
				}
				else if(type==CellType.NUMERIC)
				{
					double Nvalue=wb.getSheet(SheetName).getRow(i).getCell(i).getNumericCellValue();
					Value=String.valueOf(Nvalue);
				}
				else if(type==CellType.BLANK)
				{
					Value="";
				}
				arr[i][i]=Value;
				}

		}
		
		return arr;

		
	}
}
