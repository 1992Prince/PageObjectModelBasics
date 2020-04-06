package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.ExtentManagerTrial;
import com.w2a.utilities.ExtentReportTrial;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		ExtentManagerTrial.startTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
	
		
		ExtentManagerTrial.getTest().log(Status.PASS, "Test passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// below line 1 is added so that line 4 will be converted into html otherwise instead of link 
		// <a href='C:\\Users\\Prince\\Pictures\\Saved Pictures\\Professor.jpg'>screenshot</a> will be printed in the report
		
		ExtentManagerTrial.getTest().log(Status.FAIL, "Test Failed");
		
		
				
		System.setProperty("org.uncommons.reportng.escape-output", "false"); // line 1
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ExtentManagerTrial.getTest().fail("Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        Reporter.log("Login successfully executed"); // in report this message will be printed for this tc due to ReportNG report
        
        Reporter.log("<a target='_blank'  href="+TestUtil.screenshotName+">screenshot</a>"); // replacement of line4
        
       
    	
		
	//	Reporter.log("<a target='_blank'  href='C:\\Users\\Prince\\Pictures\\Saved Pictures\\Professor.jpg'>screenshot</a>"); // line 4
	
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext result) {
		
		
		
	}

	public void onFinish(ITestContext context) {
		ExtentManagerTrial.endTest();
		ExtentReportTrial.getInstance().flush();
		
	}

}
