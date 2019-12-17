package com.avon.healapp.products;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewServicePage {
	WebDriver driver;
	public NewServicePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickProductsSercvices() throws InterruptedException {
		WebElement product = driver.findElement(By.xpath("//div[@class='mainmenu products topmenuimage']"));
		product.click();
		Thread.sleep(1000);
	}
	
	public void clickNewService() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// New Product/Service
		driver.get("http://healappservices.in/hoscrm_test/htdocs/product/card.php?leftmenu=service&action=create&type=1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='companylogo']")));
		// Label - text
		driver.findElement(By.xpath("//input[@name='label']")).sendKeys("TestHealApp"+new Random().nextInt());
		// Status(Sales) - drop down 
		new Select(driver.findElement(By.id("statut"))).selectByVisibleText("Not for sale");
		// Status(Purchases) - drop down
		new Select(driver.findElement(By.id("statut_buy"))).selectByVisibleText("For purchase");
		// Doctor Name - drop down
		new Select(driver.findElement(By.id("refdname"))).selectByVisibleText("Anu Radha");
		// HSN code - text
		driver.findElement(By.id("hsncode")).sendKeys("HSN001");
		Thread.sleep(1000);
		// switch to iframe
		driver.switchTo().frame(0);
		// Description - text area
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys("Modification Comment TextArea 1");;
		// switch back to new products/service page
	    driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// Public URL - text
	    driver.findElement(By.xpath("//input[@name='url']")).sendKeys("www.google.com");
		// Duration - text
	    driver.findElement(By.xpath("//input[@name='duration_value']")).sendKeys("1");
		// Duration - radio button
	    WebElement radio = driver.findElement(By.xpath("//div[@class='tabBar']//input[4]"));
		radio.click();
		Thread.sleep(1000);
		// switch to iframe
		driver.switchTo().frame(1);
		// Note - text area
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys("Modification Comment TextArea 2");
		// switch back to new products/service page
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// Tags/categories	- text
		driver.findElement(By.xpath("//ul[@class='select2-choices']")).click();
		driver.findElement(By.id("select2-result-label-7")).click();
		driver.findElement(By.xpath("//ul[@class='select2-choices']")).click();
		driver.findElement(By.xpath("//div[(text()='Products >> ICU Equipment')]")).click();
		// Accountancy code(sell) -  drop down
		driver.findElement(By.id("s2id_accountancy_code_sell")).click();
		driver.findElement(By.id("s2id_autogen2_search")).sendKeys("cap");
		driver.findElement(By.xpath("//div[contains(text(),'10100')]")).click();
		// Accountancy code(buy) - drop down
		driver.findElement(By.id("s2id_accountancy_code_buy")).click();
		driver.findElement(By.id("s2id_autogen3_search")).sendKeys("Fixed");
		driver.findElement(By.xpath("//div[contains(text(),'200000')]")).click();
		driver.findElement(By.xpath("//div[@class='center']//input[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='refidno']")));
		Thread.sleep(4000);
	}
}
