package com.training.Salesforce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Leads extends SelUtility{

	public static void main(String[] args) {
	
			try {
				launchBrowser();
				goToSalesForceURL();
				loginToSalesForcePortal();
				
				clickOnLeadTab();
				CheckLeadDropDown();
				//CreateNewOpportunity();
				//OpportunityPipeLine();
				//StruckOpportunityPipeLine();
				//QuaterlyReport();
				
				//SelectMyLeads();
				NewTabOnLeadsTab();
				

			} catch (Exception E) {
				E.printStackTrace();
			} finally {
				quitBrowser();
			}

	}

	private static void NewTabOnLeadsTab() throws InterruptedException {
		driver.findElement(By.xpath("//td//input[@value=' New ']")).click();
		
		driver.findElement(By.xpath("//input[@id='name_lastlea2']")).sendKeys("ABCDE");
		driver.findElement(By.xpath("//input[@id='lea3']")).sendKeys("ABCDE");
		
		Select sel = new Select (driver.findElement(By.xpath("//select[@id='lea13']")));
		sel.selectByIndex(1);
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		
		Thread.sleep(6000);
		
		
	}

	private static void SelectMyLeads() throws InterruptedException {
		Select sel = new Select (driver.findElement(By.xpath("//select[@id='fcf']")));
		sel.selectByValue("00B4x000007asbY");
		WebElement webe= driver.findElement(By.xpath("//div[@id='userNav']"));
		waitExplicitly(5, webe);
		webe.click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
		quitBrowser();
		
		
		launchBrowser();
		goToSalesForceURL();
		loginToSalesForcePortal();
		
		
		clickOnLeadTab();
		
		Select sel2 = new Select (driver.findElement(By.xpath("//select[@id='fcf']")));
		sel2.selectByValue("00B4x000007asbm");
		
	}

	private static void clickOnLeadTab() throws InterruptedException {
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//div//a[@id='tryLexDialogX']")).click();
		
		driver.switchTo().activeElement();
		
	}
	
	
	private static void CheckLeadDropDown() {
		Select sel = new Select (driver.findElement(By.xpath("//select[@id='fcf']")));
		List<WebElement> list = sel.getOptions();
		for(int i=0;i<list.size();i++) {
			WebElement web = list.get(i);
			System.out.println(web.getText());
		}
		
		
	}

}
