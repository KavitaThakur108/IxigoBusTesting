package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage 
{
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div/div/div/div[4]/div[2]/div[2]/input")WebElement Mobile;
	@FindBy(xpath="//button[text()='Continue']")WebElement Continue_OTP;
	@FindBy(xpath="//div[@class=\"u-ib\"]")WebElement OTP;
	@FindBy(xpath="//span[text()=\"email\"]")WebElement email;
	
	

	
//------CONSTRUCTOR------------------
	
	public LoginPage(WebDriver driver) 
	{
		
		super(driver);
		this.driver=driver;
		
	}
	
	
//--------Enter Mobile Number(.properties file)----------
	
	public void mobileFilling() 
	{   
		waitUntilElementToBeClickable(Mobile);
		Mobile.click();
		Mobile.clear();
		Mobile.sendKeys(propertyReader.get("mobile.value"));
		waitUntilElementToBeClickable(Continue_OTP);
		Continue_OTP.click();	
	 }
//--------Enter OTP and Submit----------------------	
	
	public void otpFilling() 
	{
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
  
		
		driver.switchTo().defaultContent();
		waitUntilOverlayGone(By.id("sso-frame"), Duration.ofSeconds(10));
	
		
	}

}
