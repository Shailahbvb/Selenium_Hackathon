package com.training.Salesforce;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Contacts extends SelUtility {

	public static void main(String[] args) {
		try {
			launchBrowser();
			goToSalesForceURL();
			loginToSalesForcePortal();
			Properties prop = readPropertiesFile();
			clickOnContactTab();
			NewTabOnContacts(prop);
			// CreateNewView();
			// RecentlyCreatedView();
			// MyContactView();

			// clickOnContactName();
			// CreateNewViewError();
			// NewViewCancel();

			SaveAndNewButton(prop);

		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			quitBrowser();
		}
	}

	private static void SaveAndNewButton(Properties prop) throws InterruptedException {

		driver.findElement(By.xpath("//td//input[@value=' New ']")).click();

		driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys(prop.getProperty("Contact_Last_Name"));

		driver.findElement(By.xpath("//input[@id='con4']")).sendKeys(prop.getProperty("Contact_Account_Name"));

		driver.findElement(By.xpath("//input[@value='Save & New']")).click();

		Thread.sleep(6000);

	}

	private static void NewViewCancel() throws InterruptedException {
		driver.findElement(By.linkText("Create New View")).click();
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("EFGH");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//td//input[@value='Cancel']")).click();
		Thread.sleep(6000);

	}

	private static void CreateNewViewError() throws InterruptedException {

		driver.findElement(By.linkText("Create New View")).click();
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("EFGH");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//td//input[@value=\" Save \"]")).click();
		Thread.sleep(6000);

	}

	private static void clickOnContactName() throws InterruptedException {
		driver.findElement(By.xpath("//tbody/tr[6]//a")).click();
		Thread.sleep(6000);
	}

	private static void MyContactView() throws InterruptedException {

		Select sel = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		sel.selectByVisibleText("My Contacts");

		Thread.sleep(3000);

	}

	private static void RecentlyCreatedView() throws InterruptedException {
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='hotlist_mode']")));
		sel.selectByVisibleText("Recently Created");

		Thread.sleep(3000);

	}

	private static void clickOnContactTab() throws InterruptedException {
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//div//a[@id='tryLexDialogX']")).click();

		driver.switchTo().activeElement();

	}

	private static void NewTabOnContacts(Properties prop) throws InterruptedException {
		driver.findElement(By.xpath("//td//input[@value=' New ']")).click();

		driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys(prop.getProperty("Contact_Last_Name"));
		driver.findElement(By.xpath("//img[@alt=\"Account Name Lookup (New Window)\"]")).click();

		Thread.sleep(3000);
		ArrayList<String> windowsTabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windowsTabs.size());
		driver.switchTo().window(windowsTabs.get(1));

		// driver.getWindowHandles();
		driver.switchTo().frame(driver.findElement(By.id("searchFrame")));
		driver.findElement(By.id("lksrch")).sendKeys("");
		driver.findElement(By.xpath("//input[@value=' Go! ']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("resultsFrame")));
		// driver.findElement(By.id("resultsFrame")));
		driver.findElement(By.xpath("//tr[2]//a[@href=\"#\"]")).click();

		driver.switchTo().window(windowsTabs.get(0));
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();

		Thread.sleep(6000);

	}

	private static void CreateNewView() throws InterruptedException {

		driver.findElement(By.linkText("Create New View")).click();
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Account Contact Test2");
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("Account_Contact_Unique2");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//td//input[@value=\" Save \"]")).click();
		Thread.sleep(6000);

	}

}
