package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
 public	LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 @FindBy(name="uid")
 @CacheLookup
 WebElement txtUserName;
 
 @FindBy(name="password")
 @CacheLookup
 WebElement txtPassword;
 
 @FindBy(name="btnLogin")
 @CacheLookup
 WebElement btnLogin;
 
 @FindBy(xpath = "/html/body/div[3]/div/ul/li[10]/a")
 @CacheLookup
 WebElement lnkLogout;

public void setUserName(String userName)
{
	txtUserName.sendKeys(userName);
}

public void setPassword(String password)
{
	txtPassword.sendKeys(password);
}

public void clickSubmit()
{
	btnLogin.click();
	
}
public void clickLogout()
{
	lnkLogout.click();
}
}