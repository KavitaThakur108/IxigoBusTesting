package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AbhibusPage extends BasePage{
	

	public AbhibusPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
	}
	
	
//Select the offer from abhibus page------------------------------------------------------------
	public void offerSelect()
	{  
		//It took time to load the offers to get visible
		By offer=By.xpath("//img[contains(@data-page-uri,'/grandwinterbussale') and @title=\"Get 50% OFF* on 1st Booking\"]");
		WebElement offerImg = wait.until(ExpectedConditions.visibilityOfElementLocated(offer));
		wait.until(ExpectedConditions.presenceOfElementLocated( offer));
		scrollIntoView(offerImg);
        jsClick(offerImg);
	
	}
	

}
