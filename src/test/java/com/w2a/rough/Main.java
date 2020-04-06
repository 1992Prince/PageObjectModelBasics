package com.w2a.rough;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Main {
	
	  public static void main(String[] args) {
	        // start reporters
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	    
	        // create ExtentReports and attach reporter(s)
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);

	        // creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
	        
	        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		    
		    test.log(Status.INFO, "Starting tcs");
		    driver.get("https://www.google.com/");
		    test.pass("Navigated to google");
		    
		    driver.findElement(By.name("q")).sendKeys("Automation");
		    test.pass("Entered the tessxt");
		    
		    

	        // log(Status, details)
	        test.log(Status.INFO, "This step shows usage of log(status, details)");

	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        try {
				test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        // test with snapshot
	        try {
				test.addScreenCaptureFromPath("screenshot.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        // calling flush writes everything to the log file
	        extent.flush();
	  }

}
