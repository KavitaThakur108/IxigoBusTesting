package com.pages;

import org.openqa.selenium.WebDriver;

public class BankPage extends BasePage {

	public BankPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
	}
	
	
//Get the URL of specific bank:ICICI-----------------------------------------------
	public String getURL()
	{
		String secondUrl = driver.getCurrentUrl();
		return secondUrl;
	}

	

}
