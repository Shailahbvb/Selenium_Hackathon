package com.training.Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Login extends SelUtility{

	public static void main(String[] args) {
		try {
		launchBrowser();
		goToSalesForceURL();
		//checkBoxTest();
		//ErrorMsgTest();
		loginToSalesForcePortal();
		
		//forgotPasswordTest();
		
		
		}catch(Exception E) {
			E.printStackTrace();
		}finally
		{
			quitBrowser();
		}
		
		

	}

	
	

	private static void ErrorMsgTest() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//input[@type='email']"));
		waitExplicitly(5, ele);
		ele.clear();
		ele.sendKeys("shailahandigol@gmail.com");
		
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(6000);
		
	}




	private static void checkBoxTest() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//input[@type='email']"));
		waitExplicitly(5, ele);
		ele.clear();
		ele.sendKeys("shailahandigol@gmail.com");
		
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Hanuman$84");
		//driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		LogOut();
		Thread.sleep(6000);
	
		
	}




	private static void forgotPasswordTest() throws InterruptedException {
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		 Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("shailahandigol@gmail.com");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
