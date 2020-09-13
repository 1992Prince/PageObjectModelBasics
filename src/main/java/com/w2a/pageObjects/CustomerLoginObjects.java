package com.w2a.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginObjects  {
	
	public WebDriver driver;
	
	public CustomerLoginObjects(WebDriver driver){
		this.driver = driver;
	}
	
	private By customerLoginButton = By.xpath("//*[@ng-click='customer()']");
	private By loginButton = By.xpath("//*[text()='Login']");
	
	public WebElement customerLoginButtonfn() {
		return driver.findElement(customerLoginButton);
	}
	
	public WebElement loginButtonfn() {
		return driver.findElement(loginButton);
	}
	

}
