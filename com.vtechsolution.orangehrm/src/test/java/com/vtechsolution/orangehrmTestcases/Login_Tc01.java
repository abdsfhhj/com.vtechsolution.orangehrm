package com.vtechsolution.orangehrmTestcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.vtechsolution.orangehrmTestbase.TestBase;
import com.vtechsolution.orangehrmpageobject.LoginPage;

public class Login_Tc01 extends TestBase {
	LoginPage lp;

	@Test(priority = 3)
	public void LoginTc_o1() {
		

		LoginPage lp = new LoginPage(driver);
		lp.setUsername(ConfigDataProvider.getUserName());
		lp.setPassword(ConfigDataProvider.getPassword());
		lp.clickOnLoginBtn();

		if (driver.getPageSource().contains("PIM")) {
			Assert.assertTrue(true);
			System.out.println("LoginSuccess...");
		} else {
			Assert.assertTrue(false);
			System.out.println("Login fails..");
		}
	}

	@Test(priority = 2)
	public void verifyOrangeHrmlogo() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		lp = new LoginPage(driver);
		if (lp.verifyOrangeHrmlogo()) {
			Assert.assertTrue(true);
			System.out.println("Orange HRM Logo is Displayed on Login Page");
		} 
		else {
			
			System.out.println("Orange HRM Logo is not Displayed on Login Page");
			Assert.assertTrue(false);

		}
	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTc() {
		

		if (driver.getTitle().equals("OrangeHRM")) {
			Assert.assertTrue(true);
			System.out.println("Login Page title is verifyed");
		} else {
			Assert.assertTrue(false);
			System.out.println("Login Page title  is not matched with expected title");

		}
	}
}
