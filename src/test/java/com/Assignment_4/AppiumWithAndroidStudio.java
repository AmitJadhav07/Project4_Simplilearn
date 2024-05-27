package com.Assignment_4;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;


public class AppiumWithAndroidStudio {
	
	public static AndroidDriver<WebElement> webDriver;
	public static ExtentSparkReporter spark;		
	public static ExtentReports extent;		
	public static ExtentTest logger;
	public static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	public static String extentSparkReportFilePath = "./TestReport/AndroidStudio/"+timeStamp+"AutomationReport.html";
	public static String screenshotFolderName = "./Screenshot/AndroidStudio";
	public static String screenshotFileName = timeStamp+".png";

	@Test
	public void OpenApplication() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9.0");
		
		webDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(extentSparkReportFilePath);		
		spark.config().setTheme(Theme.STANDARD);
		extent.attachReporter(spark);
		logger = extent.createTest("OpenApplication");
		Thread.sleep(2000);

	//Script
		webDriver.get("https://www.swiggy.com/");
		Thread.sleep(2000);
		String pageTitle = webDriver.getTitle();
		String pageURL = webDriver.getCurrentUrl();
		System.out.println(pageTitle);
		System.out.println(pageURL);
		logger.info("Swiggy website is launched successfully :- " + pageURL);
		Thread.sleep(5000);

		try {
			System.out.println("location set up page landed");
			logger.info("Location setup page is launched successfully");
			webDriver.findElementByXPath(PageObjects.setupYourLocation_xpathLocator).click();
			Thread.sleep(5000);
			webDriver.findElementByXPath(PageObjects.locationSearchBar_xpathLocator).sendKeys("pune");
			Thread.sleep(5000);
			webDriver.findElementByXPath(PageObjects.selectLocation_xpathLocator).click();
			logger.info("Location entered");
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("location set up page not landed");
			logger.info("Skeep the location entering");
		}
		
		Thread.sleep(20000);
		webDriver.findElementByXPath(PageObjects.itemSearchButton_xpathLocator).click();
		System.out.println("food search button clicked");
		logger.info("Item search button clicked");
		Thread.sleep(20000);
		webDriver.findElementByXPath(PageObjects.itemSearchBar_xpathLocator).sendKeys("burger");
		System.out.println("item name entered");
		logger.info("Item name entered");
		Thread.sleep(20000);
		webDriver.findElementByXPath(PageObjects.selectItem1_xpathLocator).click();
		System.out.println("food1 selected");
		Thread.sleep(5000);
		webDriver.findElementByXPath(PageObjects.selectItem2_xpathLocator).click();
		System.out.println("food2 selected");
		Thread.sleep(5000);
		logger.info("Item is selected");
		webDriver.findElementByXPath(PageObjects.addItem_xpathLocator).click();
		System.out.println("food added");
		logger.info("Item is added");
		
		String selectedItemName = webDriver.findElementByXPath(PageObjects.selectedItemName_xpathLocator).getText();
		String selectedItemQty = webDriver.findElementByXPath(PageObjects.selectedItemQty_xpathLocator).getText();
		
		Thread.sleep(5000);
		webDriver.findElementByXPath(PageObjects.viewCart_xpathLocator).click();
		System.out.println("cart display");
		Thread.sleep(10000);
//		takeScreenshot();
		
		String addedItemName = webDriver.findElementByXPath(PageObjects.addedItemName_xpathLocator).getText();
		String addedItemQty = webDriver.findElementByXPath(PageObjects.addedItemQty_xpathLocator).getText();

	//Verify item is added
		System.out.println(addedItemName);
		System.out.println(addedItemQty);
		System.out.println(selectedItemName);
		System.out.println(selectedItemQty);
		
		if (addedItemName.contains(selectedItemName)) {
			logger.pass("Item is added successfully");
		}
		else {
			logger.fail("Item is not added");
			logger.info("Added item name is :- "+addedItemName);
			logger.info("Selected item name is :- "+selectedItemName);
		}
		
		if (addedItemQty.contains(selectedItemQty)) {
			logger.pass("Added item quantity is correct and verified successfully");
		}
		else {
			logger.fail("Added item quantity is incorrect");
			logger.info("Added item quantity is :- "+addedItemQty);
			logger.info("Selected item quantity is :- "+selectedItemQty);
		}
		
		
		extent.flush();
		webDriver.close();
	}
	
	
	
	
	
	
	
	
	public void takeScreenshot() {
		new File(screenshotFolderName).mkdir();
		File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile, new File(screenshotFolderName+"/"+screenshotFileName));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
//	adb uninstall io.appium.uiautomator2.server
//	adb uninstall io.appium.uiautomator2.server.test
//	
//	adb uninstall io.appium.unlock
//	adb uninstall io.appium.settings
	
	
	
	
	
	
	
	
	
	
	//Close
	//com.android.chrome
//	org.chromium.chrome.browser.document.ChromeLauncherActivity
	
	
	
	
	
	
	

	






















/*
 * 
 * 
 * package com.Assignment_4;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;

public class Reports {

	public static String destDir;
	public static SimpleDateFormat dateFormat;
	
	// Three objects we have to create with extent reports
	public static ExtentSparkReporter spark;		
	public static ExtentReports extent;		
	public static ExtentTest logger;
	
	public static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	public static String extentSparkReportFilePath = "./TestReport/"+timeStamp+"AutomationReport.html";
	
	
	
	

	public void takeScreenshot() {

		destDir = "./Screenshot";

		File srcFile = ((TakesScreenshot) Main.webDriver).getScreenshotAs(OutputType.FILE);
		dateFormat = new SimpleDateFormat("dd-MMM-YYYY__hh_mm_ssaa");
		new File(destDir).mkdir();
		String FileName = dateFormat.format(new Date()) + ".png";

		try {
			FileUtils.copyFile(srcFile, new File(destDir + "/" + FileName));
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
	
	
	
	@Test
	public void extendReport() throws InterruptedException, MalformedURLException {
				
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(extentSparkReportFilePath);		
		spark.config().setTheme(Theme.STANDARD);
		extent.attachReporter(spark);
				
		// Step 2: is to give the name for the test case
		logger = extent.createTest("extendReport");
		Thread.sleep(5000);
		
		
		
		Main.webDriver.get("https://www.amazon.in/");
		String pageTitle = Main.webDriver.getTitle();		
		String pageURL = Main.webDriver.getCurrentUrl();		
		String packagemame = Main.webDriver.getCurrentPackage();		
		System.out.println(pageTitle);		
		System.out.println(pageURL);		
		System.out.println(packagemame);		
		logger.info("Amazon website is launched success" + pageURL);	
				
		if (pageURL.equalsIgnoreCase("https://www.amazon.in/")) {		
		logger.pass("The url is correct");		
		logger.info("<Expected Result> - https://www.amazon.in/");		
		logger.info("<Actual Result> -" + pageURL);		
		}		
				
		Main.webDriver.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']")).sendKeys("Shirts");		
				
		// WebElement SearchIcon = driver.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']"));		
				
		Thread.sleep(5000);		
		Main.webDriver.findElement(By.xpath("//input[@class='nav-input']")).click();		
		Thread.sleep(2000);		
		String SearchURL = Main.webDriver.getCurrentUrl();		
		System.out.println(SearchURL);		
				
		if (SearchURL.contains("shirts")) {		
		System.out.println("The user is in Search landing page");		
		logger.pass("The user is in Search landing page");		
		}		
		else {		
		System.out.println("The user is not in the search landing page");		
		logger.fail("The user is not in the search landing page");		
		}		
				
		WebElement PoloShirt = Main.webDriver.findElement(By.xpath("(//span[text()='Polo Sports T-Shirt'])[1]"));		
				
		if (PoloShirt.isDisplayed()) {		
		System.out.println("The Polo Shirt is displayed");		
		logger.pass("The Polo Shirt is displayed");		
		}		
		else {		
		System.out.println("The Polo T shirt is not displayed");		
		logger.fail("The Polo T shirt is not displayed");		
		}		
				
		extent.flush();		
		}		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			public void takeScreenshot()
{
//Define the folder location
destDir = "./Screenshot_App/BrowserStack";

//Code for capturing the screenshot 
File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


dateFormat = new SimpleDateFormat("dd-MMM-YYYY__hh_mm_ssaa");
new File(destDir).mkdir();
String FileName = dateFormat.format(new Date())+".png";


try {
FileUtils.copyFile(srcFile, new File(destDir+"/"+FileName));
}
catch(Exception e)
{
System.out.println(e);
}
}

}

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//		try {
//			Thread.sleep(10000);
////			webDriver.findElementByAccessibilityId("Close").click();
//
////			TouchAction singleTap = new TouchAction(webDriver);
////			singleTap.tap(PointOption.point(1350, 2620)).perform();
//		}
//		catch (Exception e) {
//			System.out.println(e);
//		}	
			
			
			
			
	
		
	

}


 */
















