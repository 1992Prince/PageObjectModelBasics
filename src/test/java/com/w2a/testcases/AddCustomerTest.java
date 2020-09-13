package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import com.w2a.base.TestBase;
import com.w2a.pageObjects.CustomerLoginObjects;


public class AddCustomerTest extends TestBase{
	
	// note : if outside u want to write driver. then driver will not be identified and all its methods will not come
	
	 @Test
	 public void addCustomer() {
		 //driver.findElement(By.xpath("//*[@ng-click='customer()']")).click();
		 CustomerLoginObjects customer = new CustomerLoginObjects(driver);
		 customer.customerLoginButtonfn().click();
		 
		 WebElement element  = driver.findElement(By.id("userSelect"));
		 Select sel = new Select(element);
		 sel.selectByVisibleText("Harry Potter");
		 
		 //driver.findElement(By.xpath("//*[text()='Login']")).click();
		 customer.loginButtonfn().click();
		 
	 }
	
	/*
	 * @Test(dataProvider="getData") public void addCustomer(String fname,String
	 * lname,String pcode, String alerttext) {
	 * 
	 * driver.findElement(By.xpath(or.getProperty("addCustBtn"))).click();
	 * 
	 * driver.findElement(By.xpath(or.getProperty("fName"))).sendKeys(fname);
	 * 
	 * driver.findElement(By.xpath(or.getProperty("lName"))).sendKeys(lname);
	 * 
	 * driver.findElement(By.xpath(or.getProperty("pCode"))).sendKeys(pcode);
	 * 
	 * driver.findElement(By.xpath(or.getProperty("addCustBtn2"))).click();
	 * 
	 * 
	 * 
	 * Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	 * 
	 * Assert.assertTrue(alert.getText().contains(alerttext));
	 * 
	 * 
	 * 
	 * try { Thread.sleep(4000); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * alert.accept();
	 * 
	 * Assert.assertTrue(false);
	 * 
	 * 
	 * }
	 * 
	 * @DataProvider public Object[][] getData(){
	 * 
	 * String sheetName = "AddCustomerTest"; int rows =
	 * excel.getRowCount(sheetName); System.out.println("Rows Count "+rows); // will
	 * print 2 int cols = excel.getColumnCount(sheetName);
	 * System.out.println("Cols Count "+cols); // will print 4
	 * 
	 * Object[][] data=new Object[rows-1][cols];
	 * 
	 * for(int rowNum = 2;rowNum <= rows; rowNum++) { for(int colNum = 0; colNum <
	 * cols; colNum++) { data[rowNum-2][colNum] = excel.getCellData(sheetName,
	 * colNum, rowNum); } }
	 * 
	 * return data; }
	 */
}
