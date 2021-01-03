package com.training.Salesforce;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelUtility {

	public static WebDriver driver;
	
	public WebDriver getDriver() {
		return this.driver;
	}

	
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public  static void goToSalesForceURL() throws InterruptedException {
		driver.get("https://login.salesforce.com/");
		
		Thread.sleep(3000);
	}

	public static void waitExplicitly(int iSeconds, WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver, iSeconds);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public  static void loginToSalesForcePortal() throws InterruptedException {		
	//WebElement ele = driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[7]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/ul[1]/li[1]"));
		WebElement ele = driver.findElement(By.xpath("//input[@type='email']"));
		waitExplicitly(5, ele);
		ele.clear();
		ele.sendKeys("shailahandigol@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Hanuman$84");
		//driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		//driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[@id='userNav']")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@name='logoutButton']")).click();
		
		
		
		/*ele.sendKeys("admin123@gmail.com");
		driver.findElement(By.xpath("//input[@id='password_field']")).clear();
		driver.findElement(By.xpath("//input[@id='password_field']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@onclick='login()']")).click();
		waitExplicitly(5, driver.findElement(By.xpath("//a[contains(text(),'Home')]")));*/
	}
	
	public static void LogOut() throws InterruptedException {
		
		WebElement webe= driver.findElement(By.xpath("//div[@id='userNav']"));
		waitExplicitly(5, webe);
		webe.click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
		
		
	}
	public  static void quitBrowser() {
		driver.quit();
	}
	
	
}
