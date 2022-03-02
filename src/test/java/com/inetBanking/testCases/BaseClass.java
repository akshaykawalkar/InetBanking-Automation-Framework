package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	
	ReadConfig config= new ReadConfig();
	  public String url= config.getApplicationURL();
	public String username= config.getUserName();
    public String password= config.getPassword();
  
    public static WebDriver driver;
    public static Logger logger;
    
    @Parameters({"browser"})
    @BeforeClass
    public void setup(String browser)
    {
    	System.out.println("start");
    	 logger=Logger.getLogger("eBanking");
     	PropertyConfigurator.configure("log4j.properties");
     	
    	if (browser.equals("chrome"))
    	{
    	System.setProperty("webdriver.chrome.driver", config.getChromepath());
    	driver= new ChromeDriver();   
    	}
    	else if (browser.equals("firefox"))
    			{
    		System.setProperty("webdriver.gecko.driver", config.getFirefoxpath());
    		driver=new FirefoxDriver();
    		
    			}
    	else if (browser.equals("edge"))
    	{
    		System.setProperty("webdriver.edge.driver", config.getEdgepath());
    		driver= new EdgeDriver();
    		
    	}
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get(url);
    	driver.manage().window().maximize();
       
    }
    @AfterClass
    public void tearDown()
    {
    	driver.quit();
    	System.out.println("Stop");
    }
    public void capturescreen(WebDriver driver, String tname ) throws IOException
    {
    	 String timestamp= new SimpleDateFormat("yyyy.mm.dd,HH.mm.ss").format(new Date());
   	    String test= "Screen-shot"+timestamp+".html";
    	TakesScreenshot ts= (TakesScreenshot)driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	File target=new File(System.getProperty("user.dir")+"/Screenshots/"+test+tname+".png");
    	FileUtils.copyFile(source, target);
    	System.out.println("screenshots taken");
    	
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

}
