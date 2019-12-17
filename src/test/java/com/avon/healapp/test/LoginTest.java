package com.avon.healapp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.avon.healapp.pages.LoginPage;
import com.avon.healapp.utils.BrowserDriverFactory;


public class LoginTest extends BrowserDriverFactory{
	@Test
	public void verifyHomePage() {
		try {
			String appUrl = "http://healappservices.in/hoscrm_test/htdocs/index.php";
			driver.get(appUrl);
			String actualTitle = "";
			String expectedTitle= "Login @ 4.0.2";
			actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
//	        if (actualTitle.contains(expectedTitle)){
//	            System.out.println("Test Passed!");
//	        } else {
//	            System.out.println("Test Failed");
//	        }
	        Thread.sleep(1000);
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.loginWordPress("admin", "admin");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@id='mainmenutd_products']//a[@class='tmenuimage']")).click();
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
