package com.avon.healapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;		
	}

	public void loginWordPress(String user, String password) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(user);
        Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='button']")).click();
        Thread.sleep(2000);
	}
}


