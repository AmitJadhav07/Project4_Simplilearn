package com.Assignment_4.Docker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Assignment_4.PageObjects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DockerGrid {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest logger;
	public static String enterDeliveryLocation = "Satara";
	public static String enterProductName = "Roll";
	public static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	ArrayList<String> aryLst1 = new ArrayList<String>();

	public static WebDriver driver;
	public ChromeOptions options;

	@BeforeSuite
	public void OpenDockerInstance() throws MalformedURLException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		options = new ChromeOptions();
		String URL = "http://3.208.20.176:4444/wd/hub";
		Map<String, Object> cloudOptions = new HashMap<>();
		cloudOptions.put("build", "Sample Test Automation");
		cloudOptions.put("name", "Login Test");
		options.setCapability("cloud:options", cloudOptions);
		driver = new RemoteWebDriver(new URL(URL), options);
	}

	@Test
	public void SwiggyScript() throws InterruptedException, AWTException {
		
		
		
		
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		spark = new ExtentSparkReporter("./TestReport/Docker/"+timeStamp+"AutomationReport.html");
		spark.config().setTheme(Theme.STANDARD);
		extent.attachReporter(spark);
		logger = extent.createTest("swiggyScript");
		logger.info("Test Case Started");
		logger.pass("Browser Opened");
		
		
		
		
		
		
		
		
		
		
		
		
		
	
//enterDeliveryLocation) {
		try {
			WebElement deliveryLocation = driver.findElement(By.xpath(PageObjects.deliveryLocation_xpathLocator));
			deliveryLocation.sendKeys(enterDeliveryLocation);
			WebElement findFood = driver.findElement(By.xpath(PageObjects.findFood_xpathLocator));
			findFood.click();
			logger.pass("Delivery location entered successfully");
		}
		catch (Exception e){
			System.out.println(e);
			logger.pass("Skip enetring delivery location due to unavailability");
		}
		finally {
			WebElement searchButton = driver.findElement(By.xpath(PageObjects.searchButton_xpathLocator));
			searchButton.click();
			logger.pass("Item searching starts");
		}
	

//enterProductName
		WebElement productNameSearch = driver.findElement(By.xpath(PageObjects.productNameSearch_xpathLocator));
		productNameSearch.sendKeys(enterProductName);
		Robot rbt1 = new Robot();
		rbt1.keyPress(KeyEvent.VK_ENTER);
		WebElement selectedProductNameText = driver.findElement(By.xpath(PageObjects.selectedProductNameText_xpathLocator));
		aryLst1.add(selectedProductNameText.getText());
		logger.pass("Item name entered successfully.");
	

//add_the_product_into_cart()
		WebElement productAdd = driver.findElement(By.xpath(PageObjects.productAdd_xpathLocator));
		productAdd.click();
		Thread.sleep(2000);

		try {
			WebElement continue1 = driver.findElement(By.xpath(PageObjects.continue_xpathLocator));
			continue1.click();
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("catch block run");
		}
		
		try {
			WebElement continue2 = driver.findElement(By.xpath(PageObjects.continue_xpathLocator));
			continue2.click();
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("catch block run");
		}
		
		try {
			WebElement addItem = driver.findElement(By.xpath(PageObjects.addItem_xpathLocator));
			addItem.click();
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("catch block run");
		}

		logger.pass("Item added into cart successfully");
	

//goto_cart()
		WebElement gotoCart = driver.findElement(By.xpath(PageObjects.gotoCart_xpathLocator));
		gotoCart.click();
		logger.pass("Cart opens successfully");
	

//verify_the_prodect_is_added_successfully()
		WebElement addedProductNameText = driver.findElement(By.xpath(PageObjects.addedProductNameText_xpathLocator));
		String addedProduct = addedProductNameText.getText();
		String selectedProduct = aryLst1.get(0);
		
//		boolean verification = addedProduct.contains(selectedProduct);
//		Assert.assertTrue(verification);
		if (addedProduct.contains(selectedProduct)) {
			logger.pass("Verified that product is added successfully");
		}
		else {
			logger.fail("Product is not added correctly");
			logger.info("Selected product is :- "+selectedProduct);
			logger.info("Added product is :- "+addedProduct);
		}
		
		extent.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	

	@AfterSuite
	public void CloseDockerInstance() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*
	 * 
	 * 
	 * 3.208.20.176 - public ipv4
	 * 
	 * apt install openjdk-11-jdk java -version apt install docker docker -v apt
	 * install docker-compose docker-compose -v docker ps -a
	 * 
	 * 
	 * Docker images are available for download at following link.
	 * https://github.com/SeleniumHQ/docker-selenium Scroll down until Hub and Nodes
	 * section and refer this commands.
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
/*
}




*/

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
