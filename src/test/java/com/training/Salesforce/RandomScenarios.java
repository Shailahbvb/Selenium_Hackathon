package com.training.Salesforce;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RandomScenarios extends SelUtility{

	public static void main(String[] args) {
		try {
			launchBrowser();
			goToSalesForceURL();
			loginToSalesForcePortal();
			ClickOnHomeTab();
			//VerifyLastNameMultiple();
			//VerifyAddingNewTab();
			
		//	BlockingEventINCalender();
			//BlockingEventINCalenderWeekly();
			
			}catch(Exception E) {
				E.printStackTrace();
			}finally
			{
				//quitBrowser();
			}
	}

	private static void BlockingEventINCalenderWeekly() throws InterruptedException {
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//span[@class='pageDescription']//a")).click();
		driver.findElement(By.xpath("//div[@id='p:f:j_id25:j_id61:26:j_id64']//a")).click();
		
		if(!driver.findElement(By.xpath("//input[@id='IsRecurrence']")).isSelected()) {
			driver.findElement(By.xpath("//input[@id='IsRecurrence']")).click();
		}
		driver.findElement(By.xpath("//input[@id='rectypeftw']")).click();
		
		WebElement selectDate = driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
        
	    selectDate.click();
		
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//img[@alt='Subject Combo (New Window)']")).click();
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windows.size());
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//li[@class='listItem4']//a")).click();
		driver.switchTo().window(windows.get(0));
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
		   driver.findElement(By.xpath("//input[@id='EndDateTime']")).clear();
		driver.findElement(By.xpath("//input[@id='EndDateTime']")).sendKeys(dtf.format(now));
		
		driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).sendKeys("9:00 PM");
		
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		Thread.sleep(3000);
		
		
	}

	private static void BlockingEventINCalender() throws InterruptedException {
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='pageDescription']//a")).click();
		driver.findElement(By.xpath("//div[@id='p:f:j_id25:j_id61:28:j_id64']//a")).click();
		driver.findElement(By.xpath("//img[@alt='Subject Combo (New Window)']")).click();
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windows.size());
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//li[@class='listItem4']//a")).click();
		driver.switchTo().window(windows.get(0));
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
		   driver.findElement(By.xpath("//input[@id='EndDateTime']")).clear();
		driver.findElement(By.xpath("//input[@id='EndDateTime']")).sendKeys(dtf.format(now));
		
		driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).sendKeys("9:00 PM");
		
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		Thread.sleep(3000);
		
		
	}

	private static void VerifyAddingNewTab() throws InterruptedException {
		driver.findElement(By.xpath("//li[@id='AllTab_Tab']//a//img")).click();
		AddNewTab();
		Thread.sleep(3000);
		RemoveAddedTab();
	}

	private static void RemoveAddedTab() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Customize My Tabs']")).click();
		Thread.sleep(3000);
		//Select select = new Select(driver.findElement(By.id("p4")));
		
		//select.selectByIndex(8);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[@value='Case']")).click();
		driver.findElement(By.xpath("//a[@id='duel_select_0_left']")).click();
		//
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		Thread.sleep(3000);
		
		LogOut();
		Thread.sleep(3000);
		loginToSalesForcePortal();
		
	}

	private static void AddNewTab() throws InterruptedException {
		
			
			driver.findElement(By.xpath("//input[@value='Customize My Tabs']")).click();
			Thread.sleep(3000);
			//Select select = new Select(driver.findElement(By.id("p4")));
			
			//select.selectByIndex(8);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//option[@value='Case']")).click();
			driver.findElement(By.xpath("//a[@id='duel_select_0_right']")).click();
			//duel_select_0_left
			Thread.sleep(3000);
			driver.findElement(By.xpath("//td[@id='bottomButtonRow']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@value=' Save ']")).click();
			Thread.sleep(3000);
		
	}

	private static void VerifyLastNameMultiple() throws InterruptedException {
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='mru0054x000002LeWe']//a")).click();
		waitExplicitly(5, driver.findElement(By.xpath("//img[@title=\"Edit Profile\"]")));
		driver.findElement(By.xpath("//img[@title=\"Edit Profile\"]")).click();
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.id("contactInfoContentId")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@id='aboutTab']")).click();
		WebElement webEle = driver.findElement(By.id("firstName"));
		webEle.sendKeys("");
		Thread.sleep(3000);
		
		WebElement webEle2 = driver.findElement(By.id("lastName"));
		webEle2.clear();
		webEle2.sendKeys("Abcd");
		driver.findElement(By.xpath("//input[@value='Save All']")).click();
		
		driver.switchTo().defaultContent();
		
	}

	private static void ClickOnHomeTab() throws InterruptedException {
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//div//a[@id='tryLexDialogX']")).click();
		
		driver.switchTo().activeElement();
		
		driver.findElement(By.xpath("//h1[@class='currentStatusUserName']//a")).click();
		Thread.sleep(3000);
		
	}

}
