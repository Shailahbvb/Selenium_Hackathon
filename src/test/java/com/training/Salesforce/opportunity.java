package com.training.Salesforce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class opportunity extends SelUtility{

	
	public static void main(String[] args) {
		try {
			launchBrowser();
			goToSalesForceURL();
			loginToSalesForcePortal();
			
			clickOnOpportunityTab();
		//	CheckOpportunitydropDown();
			//CreateNewOpportunity();
			//OpportunityPipeLine();
			//StruckOpportunityPipeLine();
			QuaterlyReport();
			

		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			quitBrowser();
		}

	}

	private static void QuaterlyReport() throws InterruptedException {
		Select select = new Select(driver.findElement(By.xpath("//select[@id='quarter_q']")));
		select.selectByIndex(1);
		

		Select select1 = new Select(driver.findElement(By.xpath("//select[@id='open']")));
		select1.selectByIndex(3);
		
		driver.findElement(By.xpath("//input[@value='Run Report']")).click();
		
		
		Thread.sleep(3000);
		
		
	}

	private static void OpportunityPipeLine() throws InterruptedException {
		driver.findElement(By.linkText("Opportunity Pipeline")).click();
		
		Thread.sleep(3000);
		
	}
	
	private static void StruckOpportunityPipeLine() throws InterruptedException {
		driver.findElement(By.linkText("Stuck Opportunities")).click();
		
		Thread.sleep(3000);
		
	}

	private static void CreateNewOpportunity() throws InterruptedException {
		driver.findElement(By.xpath("//td//input[@value=' New ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id=\"opp3\"]")).sendKeys("Opportunity 1");
		driver.findElement(By.xpath("//input[@id='opp4']")).sendKeys("Opp Test");
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
			driver.findElement(By.xpath("//input[@id='opp9']")).sendKeys(dtf.format(now));
		   

			Select select = new Select(driver.findElement(By.xpath("//select[@id='opp11']")));
			select.selectByIndex(1);
			

			Select select1 = new Select(driver.findElement(By.xpath("//select[@id='opp6']")));
			select1.selectByIndex(1);
			
			
			
	
		driver.findElement(By.xpath("//input[@id='opp12']")).sendKeys("3");
		driver.findElement(By.xpath("//input[@id='opp17']")).sendKeys("last Time");
		
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
	
		
	}

	private static void CheckOpportunitydropDown() {
		Select sel = new Select (driver.findElement(By.xpath("//select[@id='fcf']")));
		List<WebElement> list = sel.getOptions();
		for(int i=0;i<list.size();i++) {
			WebElement web = list.get(i);
			System.out.println(web.getText());
		}
	}

	private static void clickOnOpportunityTab() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//li//a[@title='Opportunities Tab']")).click();
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//div//a[@id='tryLexDialogX']")).click();
		
		driver.switchTo().activeElement();
		
		
	}

}
