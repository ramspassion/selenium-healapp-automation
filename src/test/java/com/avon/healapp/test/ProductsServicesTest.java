package com.avon.healapp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.avon.healapp.pages.LoginPage;
import com.avon.healapp.products.NewServicePage;
import com.avon.healapp.utils.BrowserDriverFactory;

public class ProductsServicesTest extends BrowserDriverFactory {
	
	@Test(priority=1)
	public void verifyHomePage() {
		try {
			String appUrl = "http://healappservices.in/hoscrm_test/htdocs/index.php";
			driver.get(appUrl);
			String actualTitle = "";
			String expectedTitle= "Login @ 4.0.2";
			actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.loginWordPress("admin", "admin");
			driver.findElement(By.xpath("//li[@id='mainmenutd_products']//a[@class='tmenuimage']")).click();
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test(priority=2)
	public void createService() throws InterruptedException {
		NewServicePage newServicePage = PageFactory.initElements(driver, NewServicePage.class);
		newServicePage.clickNewService();
		Thread.sleep(1000);
	}

}
