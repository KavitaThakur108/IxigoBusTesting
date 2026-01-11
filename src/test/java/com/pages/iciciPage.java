package com.pages;

import org.openqa.selenium.WebDriver;

public class iciciPage extends BasePage {

	public iciciPage(WebDriver driver ) 
	{
		super(driver);
		this.driver=driver;
		
	}
	
//------Waiting for ICICI portal to get opened--------------------------------------------
	  public void waitForPageToLoad() {
	        try 
	        {
	            Thread.sleep(5000); // enforce minimum 5 seconds
	        } 
	        catch (InterruptedException e)
	        {
	            Thread.currentThread().interrupt();
	        }
	  }

    
	
}
