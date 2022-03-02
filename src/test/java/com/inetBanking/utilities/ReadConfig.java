package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

  public Properties pro;
	public ReadConfig()
	{
		File scr= new File("./Configuration/config.properties");
		try {
			FileInputStream fis= new FileInputStream(scr);
			pro= new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
					System.out.println("**** file not found ****");
		}
	
	}
	public String getApplicationURL()
	{
	String url= pro.getProperty("url");
	
	
	//	System.out.println("value not found exception");
	
		return url;
	}
	public String getUserName()
	{
		String userName= pro.getProperty("username");
		return userName;
	}
	public String getPassword()
	{
		String password= pro.getProperty("password");
		return password;
	}
	public String getChromepath()
	{
		String chrome= pro.getProperty("chromepath");
		return chrome;
	}
	public String getEdgepath()
	{
		String edge= pro.getProperty("edgepath");
		return edge;
	}
	public String getFirefoxpath()
	{
		String firefox= pro.getProperty("firefoxpath");
		return firefox;
	}
}
