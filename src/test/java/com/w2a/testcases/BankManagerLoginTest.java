package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		
		
		log.info("Inside Login Test");
		// note or.getProperty will return String so in xpath paranthesis accepts only string arguments
		driver.findElement(By.xpath(or.getProperty("bmlBtn"))).click();
		
		// in below assert we want to verify that element(Add Customer) button is present or not. In selenium we don't have any such message
		// so we have to create the customize message isElementPresent()
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("addCustBtn"))), "Login not Successful");
		// above it takes boolean condition i.e if condition is true then tc is passed otherwise tc is failed
		
		Assert.assertTrue(false);
		
		
		
		
		log.info("Login successfully executed");
		
	}
	

}
