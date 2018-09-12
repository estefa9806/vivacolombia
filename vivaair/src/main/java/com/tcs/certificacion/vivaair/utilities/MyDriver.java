package com.tcs.certificacion.vivaair.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyDriver {
	private WebDriver chromeDriver;
	public MyDriver()  {
		ChromeOptions co = new  ChromeOptions();
		co.addArguments("start-maximized");
	
		chromeDriver = new ChromeDriver(co);
		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	public static MyDriver suDriver(){  
		return new MyDriver();
	}
	 public WebDriver en(String url) { 
		 chromeDriver.get(url);
		 return chromeDriver;
	 }
}
