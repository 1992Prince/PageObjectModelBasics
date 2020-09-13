package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.ExtentReportTrial;



public class TestBase {
	
	/*
	 * WebDriver
	 * Properties
	 * Logs - log4j jar file
	 * ExtentReports
	 * DB
	 * Excel
	 * Mail
	 * ReportNG, Extent Report
	 * Jenkins
	 * */
	
	public static WebDriver driver ;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestBase.class.getClass());
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	
	

	
	@BeforeTest
	public void setUp() throws Exception {
		//
		// will gives the path of log4j.properties file to this class so that it follows that configuration
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties"); 
		
		if(driver==null) {
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
	        config.load(fis);
	        log.info("config file loaded");
	        log.error("Error Message");
	        
	        fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
	        or.load(fis);
	        log.info("OR file loaded");
		}
		
		if(config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "path of gecko.exe"); // this we have to do if we are working on selenium 3 release
			driver = new FirefoxDriver();
		}
		else if(config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		    driver = new ChromeDriver();
		    log.info("chrome launched   !!!");
		}
		else if(config.getProperty("browser").equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.get(config.getProperty("testsiteurl"));
		log.info("navigated to "+config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,5);
		
	}
	
	public void click(String locator) {
		driver.findElement(By.xpath(or.getProperty(locator))).click();
	}
	
	public void type(String locator, String value) {
		driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
	}
	
	public boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
			
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	
	@AfterTest
	public void teardown() {
	driver.quit();
	}
	
	
	

}
