package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		
		
		log.info("Inside Login Test");
		// note or.getProperty will return String so in xpath paranthesis accepts only string arguments
		driver.findElement(By.xpath("//*[@ng-click='manager()']")).click();
		
		driver.findElement(By.xpath("//*[@ng-click='openAccount()']")).click();
		
		WebElement ele = driver.findElement(By.id("userSelect"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("Harry Potter");
		
		WebElement element = driver.findElement(By.id("currency"));
		Select sel1 = new Select(element);
		sel1.selectByVisibleText("Dollar");
		
		driver.findElement(By.xpath("//*[text()=\"Process\"]")).click();
		
		Alert alert = driver.switchTo().alert();
		String alertmessage = alert.getText();
		System.out.println("Alert Message :"+alertmessage);
		
		Thread.sleep(3000);
		
		
		
		// in below assert we want to verify that element(Add Customer) button is present or not. In selenium we don't have any such message
		// so we have to create the customize message isElementPresent()
		//Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("addCustBtn"))), "Login not Successful");
		// above it takes boolean condition i.e if condition is true then tc is passed otherwise tc is failed
		
		//Assert.assertTrue(false);
		
		
		
		
		log.info("Login successfully executed");
		
	}
	

}
