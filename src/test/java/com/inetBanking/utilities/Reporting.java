package com.inetBanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter

{
  public ExtentHtmlReporter htmlReporter;
  public ExtentReports extent;
  public ExtentTest logger;
  
  public void onStart(ITestContext testContext)
  {
	  String timestamp= new SimpleDateFormat("yyyy.mm.dd,HH.mm.ss").format(new Date());
	  String repName= "Test-Report-"+timestamp+".html";
	  htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
	//  htmlReporter.loadConfig(System.getProperty("user.dir")+"/extent-confi.xml");
	  htmlReporter.loadConfig("C:\\Users\\Coditas\\eclipse-workspace\\inetBankingV1\\extent-config.xml");
	  extent= new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  extent.setSystemInfo("Host name", "localhost");
	  extent.setSystemInfo("Environment", "QA");
	  extent.setSystemInfo("User", "Akshay");
	  
	  htmlReporter.config().setDocumentTitle("inetBanking Test Project");
	  htmlReporter.config().setReportName("Functional Test Report");
	//  htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	  htmlReporter.config().setTheme(Theme.DARK);
  }
  
  public void onTestSuccess(ITestResult tr)
  {
	  logger=extent.createTest(tr.getName());
	  logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
  }
  
  public void onTestFailure(ITestResult tr)
  {
	  logger=extent.createTest(tr.getName());
	  logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	  String screenshortpath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	  File f=new File(screenshortpath);
	  
	  if(f.exists())
	  {
		  try {
			  logger.fail("screenshot is below:" + logger.addScreenCaptureFromPath(screenshortpath));
		  }
		  catch (Exception e) {
       e.printStackTrace();
		  }
	  }	  
  }
  public void onTestSkipped(ITestResult tr)
  {
	  logger=extent.createTest(tr.getName());
	  logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
  }
  
  public void onFinish(ITestContext testContext)
  {
	  extent.flush();
  }
  
  

}
