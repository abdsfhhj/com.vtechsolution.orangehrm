package com.vtechsolution.orangehrmutility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	public static Properties prop;
	
	public ConfigDataProvider(String configpath)
	{
		try {
			
		 FileInputStream fins = new FileInputStream(configpath);
		prop = new Properties();
		prop.load(fins);
			
		} catch (Exception e) {
			System.out.println("File not found:"+ e.getMessage());
			
		}
	}
	
	public String searchkey(String Keyname)
	{
		return prop.getProperty(Keyname);
	}
	public String getUserName()
	{
	return	prop.getProperty("username");
	}
	
	public String getPassword()
	{
	return	prop.getProperty("password");
	}
	public String getappurl()
	{
	return	prop.getProperty("appurl");
	}



}
