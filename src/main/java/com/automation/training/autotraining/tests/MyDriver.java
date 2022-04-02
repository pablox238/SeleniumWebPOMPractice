package com.automation.training.autotraining.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {
	private WebDriver webDriver;

	public MyDriver(String browser) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-infobars");
		this.webDriver=new ChromeDriver(options);
		this.webDriver.manage().window().maximize();
		
	}
	
	public WebDriver getDriver() {
		return this.webDriver;
	}
}
