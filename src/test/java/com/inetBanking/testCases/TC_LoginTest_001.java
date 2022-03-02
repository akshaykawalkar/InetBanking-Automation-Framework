package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
   @Test
	public void loginTest() throws IOException 
	{
		driver.get(url);
		logger.info("URL is open");
		LoginPage lp= new LoginPage(driver);
		logger.info("Enter User Name");
		lp.setUserName(username);
		logger.info("Enter Password");
		lp.setPassword(password);
		logger.info("Click on login button");
      String tile=driver.getTitle();
      System.out.println(tile);
		lp.clickSubmit();
		if(tile.equals("GTPL Bank Home Page"))
		{		logger.info("login test pass");
			Assert.assertTrue(true);
		}
		else {
			capturescreen(driver,"loginTest");
		Assert.assertTrue(false);
	   
	}}
}
