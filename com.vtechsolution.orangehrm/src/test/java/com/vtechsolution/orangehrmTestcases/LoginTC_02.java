package com.vtechsolution.orangehrmTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtechsolution.orangehrmTestbase.TestBase;
import com.vtechsolution.orangehrmpageobject.LoginPage;
import com.vtechsolution.orangehrmutility.ExcelDataProvider;

public class LoginTC_02 extends TestBase {
	
	LoginPage lp;
	@Test
	public void LoginTc_o2() {
		

		 lp = new LoginPage(driver);
		//lp.setUsername(ExcelDataProvider.getStringCellData(0, 1, 0));
		//lp.setPassword(ExcelDataProvider.getStringCellData(0, 1, 1));
		 
		 lp.setUsername(ExcelDataProvider.getStringCellData("login", 1, 0));
		 lp.setPassword(ExcelDataProvider.getStringCellData("login", 1, 1));
		 
		lp.clickOnLoginBtn();

		if (driver.getPageSource().contains("PIM")) {
			Assert.assertTrue(true);
			System.out.println("LoginSuccess...");
		} else {
			Assert.assertTrue(false);
			System.out.println("Login fails..");
		}
	}



}
