package com.avon.healapp.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriverFactory {

	public WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
//		switch (browser) {
//			case "chrome":
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//				driver.manage().window().maximize();
//			break;
//	
//			case "firefox":
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//				driver.manage().window().maximize();
//			break;
//	
//			default:
//					WebDriverManager.chromedriver().setup();
//					driver = new ChromeDriver();
//					driver.manage().window().maximize();	
//					driver.close();
//				break;
//			}
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}