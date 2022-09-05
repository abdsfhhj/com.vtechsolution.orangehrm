package com.vtechsolution.orangehrmTestbase;



import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.vtechsolution.orangehrmutility.ConfigDataProvider;
import com.vtechsolution.orangehrmutility.ExcelDataProvider;
import com.vtechsolution.orangehrmutility.constantvariable;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	public WebDriver driver;
	public static ConfigDataProvider ConfigDataProvider;
	public static ExcelDataProvider excelDataProvider;
	    @BeforeSuite
	   public void init()
	   {
	    	ConfigDataProvider = new ConfigDataProvider(constantvariable.ConfigDataPath);
	    	excelDataProvider  = new ExcelDataProvider(constantvariable.excelPath);
	   }

	@BeforeMethod
	@Parameters({ "brname"})
	public void setUp(@Optional("Chrome") String browser) {
		if (browser.equals("Chrome")) {
			 WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			 driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
		}

		else {
			System.out.println("browser set Up doesn't match with required browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(ConfigDataProvider.getappurl());
		
	}

	@AfterMethod
	public void teardown() throws Exception {

		Thread.sleep(5000);
		driver.quit();
	}

}
