package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver driver;
public AddCustomerPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

 @FindBy(how = How.LINK_TEXT, using="New Customer")
 @CacheLookup
 WebElement lnkAddNewCustomer;
 
 @FindBy(how=How.NAME, using="name")
 @CacheLookup
 WebElement txtCustomerName;
 
 @FindBy(how=How.NAME, using="rad1")
 @CacheLookup
 WebElement rdGender;
 
 @FindBy(how=How.ID_OR_NAME, using="dob")
 WebElement txtdob;
 
 @FindBy(how=How.NAME, using="addr")
 WebElement txtaddress;
 
 @FindBy(how=How.NAME, using= "city")
 WebElement txtcity;
 
 @FindBy(how=How.ID_OR_NAME, using="state")
 WebElement txtstate;
 
 @FindBy(how=How.NAME, using="pinno")
 WebElement txtpin;
 
 @FindBy(how=How.NAME, using="telephoneno")
 WebElement txttelephone;
 
 @FindBy(how=How.NAME, using="emailid")
 WebElement txtemail;
 
 @FindBy(how=How.XPATH, using="//input[@value='Submit']")
 WebElement btnsubmit;
 
 public void clickAddNewCustomer()
 {
	 lnkAddNewCustomer.click();
 }
 
 public void custName(String name)
 {
	 txtCustomerName.sendKeys(name);
 }
 
 public void custgender()
 {
	 rdGender.click();
 }
 
 public void custdob(String mm, String dd, String yyyy)
 {
	 txtdob.sendKeys(mm);
	 txtdob.sendKeys(dd);
	 txtdob.sendKeys(yyyy);
 }
 
 public void custaddress(String address)
 {
	 txtaddress.sendKeys(address);
 }
 
 public void custcity(String city)
 {
	 txtcity.sendKeys(city);
 } 
 
 public void custstate(String state)
 {
	 txtstate.sendKeys(state);
 }
 
 public void custpin(String pin)
 {
	 txtpin.sendKeys(pin);
 }
 
 public void custtelephone(String telephone)
 {
	 txttelephone.sendKeys(telephone);
 }
 public void custemail(String email)
 {
	 txtemail.sendKeys(email);
 }
 
 public void custsumbit()
 {
	 btnsubmit.click();
 }
}

