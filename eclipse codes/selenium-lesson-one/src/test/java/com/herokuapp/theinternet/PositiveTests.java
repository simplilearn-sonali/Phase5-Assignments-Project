package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
	@Test
	public void loginTest() {
		System.out.println("Starting the loginTest");
  
		//create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		sleep(5000);
		
		//maximize browser window
		driver.manage().window().maximize();
		
		//open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is Opened");
		
		sleep(3000);
		
		//enter the username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		sleep(3000);
		
		//enter the password
		WebElement password = driver.findElement(By.name("password"));
	    password.sendKeys("SuperSecretPassword!");
		sleep(3000);
		
		//click login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		sleep(5000);
		
		//verification on new URL
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,"Actual page url is not the same as expected.");
		
		//logout button is visible
		WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logOutButton.isDisplayed(),"Log out button is not visible");
		
		//successful login message
		//WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
		WebElement successMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successMessage.getText();
		//Assert.assertEquals(actualMessage, expectedMessage,"Actual page Message is not the same as expected.");
		
		Assert.assertTrue(actualMessage.contains(expectedMessage),"Actual message doesnot contain expected message. \n Actual Message :" + actualMessage + "\n Expected Message: " +expectedMessage);
		//close the browser
		driver.quit();
	}
	private void  sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
