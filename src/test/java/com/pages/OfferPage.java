package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OfferPage extends BasePage {
	
	@FindBy(xpath="//div//a//img[@src=\"https://static.abhibus.com/offerbanners/Dec2025/10/grandbusoffer-v2-copy.png\"]")WebElement offercopy;
    @FindBy(xpath="//a[@data-code=\"GRANDSALE\" or text()=\"Copy Code\"]")WebElement offercode; 
	
    
    public OfferPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		
	}
    
 //Copying offer code to get browser alert----------------------------------------------  
	public void offerCopy()
	{
		waitUntilVisibilityOfElement(offercopy);
		waitUntilElementToBeClickable(offercopy);
		offercopy.click();
	}
	


}
