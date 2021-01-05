package com.training.Salesforce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount extends SelUtility {

	public static void main(String[] args) {
		try {
			launchBrowser();
			goToSalesForceURL();
			loginToSalesForcePortal();
			Properties prop = readPropertiesFile();

			clickOnAccountTab();
			// CreateNewAccount();

			// CreateNewView();
			// EditView();

			// MergeAccount();

			CreateReports(prop);

		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			quitBrowser();
		}

	}

	private static void clickOnAccountTab() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//li[@id='Account_Tab']")).click();
		Thread.sleep(3000);

		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//div//a[@id='tryLexDialogX']")).click();

		driver.switchTo().activeElement();
		Thread.sleep(3000);

	}

	private static void CreateReports(Properties prop) throws InterruptedException, AWTException {

		driver.findElement(By.partialLinkText("last activity >")).click();
		Thread.sleep(1000);

		WebElement ele = driver.findElement(By.xpath("//input[@id='ext-gen20']"));
		ele.click();

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//div[@class='x-combo-list-item'][1]"))).click().build()
				.perform();

		// ele.sendKeys("Created Date");;

		Thread.sleep(1000);
		// driver.findElement(By.xpath("//img[@id='ext-gen152']")).click();
		driver.findElement(By.xpath("//input[@name=\"startDate\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"startDate\"]")).sendKeys(prop.getProperty("From_date"));

		Thread.sleep(3000);
		// driver.findElement(By.xpath("//button[@id='ext-gen329']")).click();

		// driver.findElement(By.xpath("//img[@id='ext-gen154']")).click();
		driver.findElement(By.xpath("//input[@name=\"endDate\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"endDate\"]")).sendKeys(prop.getProperty("To_date"));

		Thread.sleep(4000);
		// driver.findElement(By.xpath("//button[@id='ext-gen348']']")).click();
		// button[@id='ext-gen348']
		// Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//table[@id='saveReportBtn']")).click();

		// driver.switchTo(driver.findElement(By.id("saveReportDlg")));

		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(0));
		driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"))
				.sendKeys(prop.getProperty("Report_name"));

		driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"))
				.sendKeys("Unique_Report_Name" + System.currentTimeMillis());

		Thread.sleep(3000);

		driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']")).click();
		Thread.sleep(3000);

	}

	private static void MergeAccount() throws InterruptedException {

		driver.findElement(By.linkText("Merge Accounts")).click();
		driver.findElement(By.xpath("//input[@id='srch']")).sendKeys("Selenium Test");

		driver.findElement(By.xpath("//input[@name='srchbutton']")).click();
		Thread.sleep(3000);

		// driver.findElement(By.xpath("//input[@id='cid0']")).click();
		// driver.findElement(By.xpath("//input[@id='cid0']")).click();
		driver.findElement(By.xpath("//input[@value=' Next ']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@value=' Merge ']")).click();
		Thread.sleep(3000);

	}

	private static void EditView() throws InterruptedException {

		Select select = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		select.selectByValue("00B4x000005uhIB");

		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Account Test2");
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("Account_Unique2");

		Select select2 = new Select(driver.findElement(By.xpath("//td//select[@id=\"fcol1\"]")));
		select2.selectByIndex(1);

		Select select3 = new Select(driver.findElement(By.xpath("//td//select[@id=\"fop1\"]")));
		select3.selectByIndex(4);

		driver.findElement(By.xpath("//td//input[@id=\"fval1\"]")).sendKeys("A");
		driver.findElement(By.xpath("//td//input[@value=\" Save \"]")).click();

	}

	private static void CreateNewView() throws InterruptedException {

		driver.findElement(By.linkText("Create New View")).click();
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Account Test");
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("Account_Unique");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//td//input[@value=\" Save \"]")).click();

	}

	private static void CreateNewAccount() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//td//input[@value=\" New \"]")).click();

		WebElement webe = driver.findElement(By.xpath("//input[@id='acc2']"));
		waitExplicitly(5, webe);
		webe.sendKeys("Selenium Test");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//td//input[@id='acc5']")).sendKeys("123445677");

		Select select = new Select(driver.findElement(By.xpath("//select[@id='acc6']")));
		select.selectByValue("Technology Partner");

		Select select1 = new Select(driver.findElement(By.xpath("//select[@id='00N4x00000DcqFy']")));
		select1.selectByValue("High");

		driver.findElement(By.xpath("//td//input[@value=\" Save \"]")).click();

		Thread.sleep(3000);

	}
}
