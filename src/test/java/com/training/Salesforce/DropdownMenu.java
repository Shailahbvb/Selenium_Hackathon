package com.training.Salesforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropdownMenu extends SelUtility {

	public static void main(String[] args) {
		try {
			launchBrowser();
			goToSalesForceURL();
			loginToSalesForcePortal();
			Properties prop = readPropertiesFile();

			// forgotPasswordTest();
			DropDownMenuMyProfile(prop);
			// DropDownMenuMySettings();
			DropDownDeveloperConsol();

			// LogOut();

		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			quitBrowser();
		}

	}

	private static void DropDownDeveloperConsol() throws InterruptedException {
		WebElement webe = driver.findElement(By.xpath("//div[@id='userNav']"));
		waitExplicitly(5, webe);
		webe.click();
		driver.findElement(By.xpath("//a[@title='Developer Console (New Window)']")).click();

		Thread.sleep(3000);
		List<String> list = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(list.get(1)).close();
		driver.switchTo().window(list.get(0));
		Thread.sleep(3000);
	}

	private static void DropDownMenuMyProfile(Properties prop) throws InterruptedException {
		WebElement webe = driver.findElement(By.xpath("//div[@id='userNav']"));
		waitExplicitly(5, webe);
		webe.click();

		driver.findElement(By.xpath("//a[@class='menuButtonMenuLink firstMenuItem']")).click();
		Thread.sleep(3000);

		 EditDetails(prop);

		 PostComments(prop);

		 fileUpload(prop);
		imageUpload(prop);

	}

	private static void EditDetails(Properties prop) throws InterruptedException {
		waitExplicitly(5, driver.findElement(By.xpath("//img[@title=\"Edit Profile\"]")));
		driver.findElement(By.xpath("//img[@title=\"Edit Profile\"]")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("contactInfoContentId")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@id='aboutTab']")).click();
		Thread.sleep(3000);
		WebElement webEle = driver.findElement(By.id("lastName"));
		webEle.clear();
		webEle.sendKeys(prop.getProperty("last_name_test"));
		driver.findElement(By.xpath("//input[@value='Save All']")).click();

		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[@class=\"publisherattachtext \"]")).click();
		Thread.sleep(1000);

	}

	private static void fileUpload(Properties prop) throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'File')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//input[@id='chatterFile']")).click();
		driver.findElement(By.xpath("//input[@id='chatterFile']")).sendKeys(prop.getProperty("file"));
		Thread.sleep(3000);
		WebElement iframeMsg = driver.findElement(By.xpath("//*[contains(@class, 'cke_wysiwyg_frame cke_reset')]"));
		driver.switchTo().frame(iframeMsg);
		WebElement body = driver.findElement(By.cssSelector("body"));
		System.out.println(body.getText());

		body.sendKeys(prop.getProperty("done"));
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
		Thread.sleep(6000);

	}

	private static void imageUpload(Properties prop) throws InterruptedException {
		Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("//div[@class=\"photoUploadSection\"]"))).perform();

		action.moveToElement(driver.findElement(By.xpath("//div[@id='photoSection']"))).perform();

		Thread.sleep(3000);
		// iframe[@id='uploadPhotoContentId']
		driver.findElement(By.xpath("//a[contains(text(),'Add')]")).click();

		driver.switchTo().frame(driver.findElement(By.id("uploadPhotoContentId")));

		// action.moveToElement(driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']")))
		// ;
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//div[@id='uploadPhoto']")).click();
		driver.findElement(By.xpath("//input[@class='fileInput']")).sendKeys(prop.getProperty("img_file"));
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:photoVisibility']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']")).click();
	}

	private static void PostComments(Properties prop) throws InterruptedException {
		WebElement iframeMsg = driver.findElement(By.xpath("//*[contains(@class, 'cke_wysiwyg_frame cke_reset')]"));
		driver.switchTo().frame(iframeMsg);
		WebElement body = driver.findElement(By.cssSelector("body"));
		System.out.println(body.getText());
		body.clear();
		body.sendKeys(prop.getProperty("comment")+": "+ System.currentTimeMillis());

		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
		Thread.sleep(3000);

	}

	private static void DropDownMenuMySettings() throws InterruptedException {

		WebElement webe = driver.findElement(By.xpath("//div[@id='userNav']"));
		waitExplicitly(5, webe);
		webe.click();
		driver.findElement(By.xpath("//a[@title='My Settings']")).click();

		// PersonalInfoTab();
		// CustomizeMYTab();
		EmailSetUp();

	}

	private static void EmailSetUp() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='EmailSetup']")).click();

		driver.findElement(By.xpath("//span[@id='EmailSettings_font']")).click();
		driver.findElement(By.xpath("//input[@id='auto_bcc0']")).click();
		Thread.sleep(3000);

	}

	private static void PersonalInfoTab() {
		driver.findElement(By.id("PersonalInfo")).click();
		driver.findElement(By.id("LoginHistory_font")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Download login')]")).click();
		// Thread.sleep(3000);

	}

	private static void CustomizeMYTab() throws InterruptedException {
		driver.findElement(By.id("DisplayAndLayout_font")).click();
		driver.findElement(By.id("CustomizeTabs_font")).click();
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.id("p4")));

		select.selectByIndex(8);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[@value='report']")).click();
		driver.findElement(By.xpath("//a[@id='duel_select_0_right']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']")).click();
		Thread.sleep(3000);

	}

}
