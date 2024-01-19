package com.project.Dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.Reporter;

public class ConfigClass {

	
	public static String getProperty(String key)
	{
		Properties prop=new Properties();
	
		try {
			prop.load(new FileInputStream(new File("./ConfigProperties/ConfigDetails")));
		} catch (IOException e) {
			
			Reporter.log("Log Info - Unable to Config File");
		}		
		
String value=prop.getProperty(key);
return value;

	
	}
}

