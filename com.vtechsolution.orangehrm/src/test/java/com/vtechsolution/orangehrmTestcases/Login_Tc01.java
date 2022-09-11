package com.vtechsolution.orangehrmTestcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.vtechsolution.orangehrmTestbase.TestBase;
import com.vtechsolution.orangehrmpageobject.LoginPage;

public class Login_Tc01 extends TestBase {
	LoginPage lp;

	@Test(priority = 4)
	public void LoginTc_o1() {
		
		extentTest = extentReports.createTest("LoginTc_o1");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(ConfigDataProvider.getUserName());
		lp.setPassword(ConfigDataProvider.getPassword());
		lp.clickOnLoginBtn();

		if (driver.getPageSource().contains("PIM")) {
			Assert.assertTrue(true);
			extentTest.info("LoginSuccess...");
			//System.out.println("LoginSuccess...");
		} else {
			Assert.assertTrue(false);
			extentTest.info("Login fails..");
			System.out.println("Login fails..");
		}
	}

	@Test(priority = 2,enabled = false)
	public void verifyOrangeHrmlogo() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		extentTest = extentReports.createTest("verifyOrangeHrmlogo");
		
		lp = new LoginPage(driver);
		if (lp.verifyOrangeHrmlogo()) {
			Assert.assertTrue(true);
			extentTest.info("Orange HRM Logo is Displayed on Login Page");
			//System.out.println("Orange HRM Logo is Displayed on Login Page");
		} 
		else {
			
			System.out.println("Orange HRM Logo is not Displayed on Login Page");
			extentTest.info("Orange HRM Logo is not Displayed on Login Page");
			Assert.assertTrue(false);

		}
	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTc() {
		
		 extentTest = extentReports.createTest("verifyLoginPageTitleTc");
		
		if (driver.getTitle().equals("OrangeHRM")) {
			Assert.assertTrue(true);
			extentTest.info("Login Page title is verifyed");
			//System.out.println("Login Page title is verifyed");
		} else {
			Assert.assertTrue(false);
			extentTest.info("Login Page title  is not matched with expected title");
			
			//System.out.println("Login Page title  is not matched with expected title");

		}
	}
}
