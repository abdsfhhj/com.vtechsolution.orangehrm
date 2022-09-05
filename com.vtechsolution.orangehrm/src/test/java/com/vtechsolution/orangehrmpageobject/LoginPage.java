package com.vtechsolution.orangehrmpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}


	@FindBy(xpath = "//input[@name='username']")
	WebElement txtUsername;

	@FindBy(xpath = "//input[@name='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Loginbtn;
	
	//@FindBy(xpath = "//div[@class='orangehrm-login-branding']/img")
	//WebElement imageLogo;
	
	@FindBy(xpath = "//div[@class='orangehrm-login-branding']/img")
	WebElement imgLogo;
	
	
	public boolean verifyOrangeHrmlogo()
	{
		try {
		return imgLogo.isDisplayed();
			
		} catch (Exception e) {
		return false;
		}
	}

	public void setUsername(String uname) {
		try {
			txtUsername.clear();
			txtUsername.sendKeys(uname);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	public void setPassword(String upassword) {
		try {
			txtPassword.clear();
			txtPassword.sendKeys(upassword);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickOnLoginBtn() {
		try {
		Loginbtn.click();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
