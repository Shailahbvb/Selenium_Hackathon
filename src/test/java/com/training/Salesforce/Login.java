package com.training.Salesforce;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Login extends SelUtility {

	public static void main(String[] args) {
		try {
			launchBrowser();
			goToSalesForceURL();
			readPropertiesFile();

			Properties prop = readPropertiesFile();
			checkBoxTest(prop);
			// ErrorMsgTest(prop);
			loginToSalesForcePortal();

			forgotPasswordTest(prop);

		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			quitBrowser();
		}

	}

	private static void ErrorMsgTest(Properties prop) throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//input[@type='email']"));
		waitExplicitly(5, ele);
		ele.clear();
		ele.sendKeys(prop.getProperty("username"));

		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);

	}

	private static void checkBoxTest(Properties prop) throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//input[@type='email']"));
		waitExplicitly(5, ele);
		ele.clear();
		ele.sendKeys(prop.getProperty("username"));

		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(prop.getProperty("password"));
		// driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		LogOut();
		Thread.sleep(3000);

	}

	private static void forgotPasswordTest(Properties prop) throws InterruptedException {
		driver.findElement(By.linkText("Forgot Your Password?")).click();

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(prop.getProperty("username"));

		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
