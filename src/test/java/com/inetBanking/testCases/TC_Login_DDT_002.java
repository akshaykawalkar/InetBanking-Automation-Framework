package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;
import com.inetBanking.utilities.XLUtilies;

public class TC_Login_DDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd, String validation) throws InterruptedException, IOException
	{
		System.out.println("in login test");
		LoginPage lp=new LoginPage(driver);
	
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		if (validation.equals("Valid"))
		{
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			capturescreen(driver, "login");
			logger.warn("Login failed");
			Assert.assertTrue(false);
		}
		else
		{
			
			logger.info("Login passed");
			lp.clickLogout();
		//	Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		}
		}
		else if (validation.equals("Invalid"))
			if(isAlertPresent()==true)
			{
				logger.info("Login passed");
				//Thread.sleep(3000);
				driver.switchTo().alert().accept();//close logout alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
			}
			else
			{
				
				capturescreen(driver, "login");
				driver.switchTo().alert().accept();//close alert
				driver.switchTo().defaultContent();
				logger.warn("Login failed");
				Assert.assertTrue(false);
			}
		
		
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
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
	//	String path="C:\\Users\\Coditas\\eclipse-workspace\\inetBankingV1\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";

		System.out.println("in get data ");
		int rownum=XLUtilies.getRowCount(path, "Sheet1");
		int colcount=XLUtilies.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtilies.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
		System.out.println("get data befor return");
		System.out.println(logindata[0][0]);
	return logindata;
	
	}
	
}
