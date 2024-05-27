package com.Assignment_4;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AppiumWithBrowserstack {

	public static String USERNAME = "<paste User Name here>";
	public static String AUTOMATE_KEY = "<paste Access Key here>";
	public static String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static WebDriver driver;

	@Test
	public void MobileCloudTest() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("os_version", "17");
		capabilities.setCapability("device", "iPhone 13");
		capabilities.setCapability("browser", "Safari");
		driver = new RemoteWebDriver(new URL(URL), capabilities);
		
		driver.get("https://www.amazon.in/");
		String pageTitle = driver.getTitle();
		String pageURL = driver.getCurrentUrl();
		System.out.println(pageTitle);
		System.out.println(pageURL);
		driver.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']")).sendKeys("Shirts");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='nav-input']")).click();
		
		
		
		driver.quit();
	}
}




