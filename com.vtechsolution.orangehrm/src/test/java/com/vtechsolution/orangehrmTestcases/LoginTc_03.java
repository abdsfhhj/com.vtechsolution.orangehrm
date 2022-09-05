package com.vtechsolution.orangehrmTestcases;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtechsolution.orangehrmTestbase.TestBase;
import com.vtechsolution.orangehrmpageobject.LoginPage;
import com.vtechsolution.orangehrmutility.ExcelDataProvider;

public class LoginTc_03 extends TestBase {
	
	
	@Test(dataProvider="getData")
	public void verifylogin(String username,String password)
	{
		LoginPage login = new LoginPage(driver);
		login.setUsername(username);
		login.setPassword(password);
		login.clickOnLoginBtn();
		if (driver.getPageSource().contains("PIM")) {
			Assert.assertTrue(true);
			System.out.println("Login Success...");
		} 
		else if(driver.getPageSource().contains("Invalid credentials")) {
			Assert.assertTrue(true);
			System.out.println("Entered Invalid credentials login should be fail !!!!! ");
	
		}
		else {
			Assert.assertTrue(false);
			System.out.println("Login Success..");
		}

		
			
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = ExcelDataProvider.getExcelData("Login1");
		return data;
	  
	}
}
