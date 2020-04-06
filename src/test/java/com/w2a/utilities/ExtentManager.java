package com.w2a.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent; //  ExtentReports is the class
	
	// below method will gives the instance of Class ExtentReports
	public static ExtentReports getInstance() {
		
		if(extent==null) {
			
			//extent.html report will be generated in specified path
			//extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			extent = new ExtentReports(System.getProperty("user.dir")+"//test-output//testReport.html");
			
			
			// load the ReportsConfig.xml file
			extent.loadConfig(new File(System.getProperty("user.dir")+"//src//test//resources//extentConfig//ReportsConfig.xml"));
		}	
		
		return extent;
		
	}
	

}
