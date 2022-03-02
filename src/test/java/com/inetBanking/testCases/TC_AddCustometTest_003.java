package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.AddCustomerPage;
import com.inetBanking.pageObject.LoginPage;

@Test
public class TC_AddCustometTest_003 extends BaseClass
{

	public void addNewCustomer() throws InterruptedException, IOException {
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	logger.info("user name");
	lp.setPassword(password);
	logger.info("user password");

	lp.clickSubmit();
	Thread.sleep(3000);
	
	AddCustomerPage addcust=new AddCustomerPage(driver);
	
	addcust.clickAddNewCustomer();
	try {
		driver.switchTo().alert().dismiss();
		logger.info("alert is accepted");
	}
	catch(Exception e)
	{
		logger.info("No alert os present");
	}
	logger.info("clicked on the link");
	addcust.custName("Akshay");
	logger.info("User Name entered");
	addcust.custgender();
	logger.info("gender entered");
	addcust.custdob("10", "10", "1996");
	logger.info("dob entered");
	Thread.sleep(3000);
    addcust.custaddress("nimgaon");
	logger.info("address entered");
    addcust.custcity("Nandura");
    logger.info("city entered");
    addcust.custstate("maharastra");
    logger.info("state entered");
    addcust.custpin("443404");
    logger.info("pin entered");
    addcust.custtelephone("1234567");
    logger.info("telephone entered");
    String mail=random()+"@test.com";
    addcust.custemail(mail);
    logger.info("email entered");
	Thread.sleep(6000);
    addcust.custsumbit();
	Thread.sleep(6000);
    boolean res=driver.getPageSource().contains("Connection failed: Access denied for user 'root'@'localhost' (using password: NO)");
	logger.info("validation start");
	
   
    if(res ==true)
    {
    	logger.info("test case is pass");
    	Assert.assertTrue(true);
    }
    else
    {  capturescreen(driver, "addnewcustomer");
	logger.info("test case is fail");

    	Assert.assertTrue(false);
    }
	}
	public String random()
	{
	String random=RandomStringUtils.randomAlphabetic(5);
	return random;
	}
	public String randomnumb()
	{
		String a=RandomStringUtils.randomNumeric(4);
		return a;
	}
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
}
