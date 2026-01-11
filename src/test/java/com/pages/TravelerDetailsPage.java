package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TravelerDetailsPage extends BasePage{
	
	@FindBy(xpath="//button[text()='Continue to Pay ₹ ']")WebElement ContinuePaybtn;
	@FindBy(xpath="//span[text()=\"Please Enter Valid Name\"]")WebElement emptyName;
	@FindBy(css  ="input[placeholder='Name']")WebElement name;
	@FindBy(css  ="input[placeholder='Age']")WebElement age;
	@FindBy(css  ="input[placeholder='Enter Email Address']")WebElement email;
	@FindBy(xpath="//input[@data-id=\"0\" and @type=\"checkbox\"]")WebElement insurancebtn;
	@FindBy(xpath="//div[@id='fare-details-card']//small[normalize-space(.)='Travel Insurance']")WebElement insuranceLabel;
    @FindBy(xpath="//h5[text()=\"Billing address\"]")WebElement Billingbtn;
   // @FindBy(xpath= "//a[text()='Save']")WebElement Billing_save;
    @FindBy(linkText="Save")WebElement Billing_save;
    @FindBy(xpath="//label[normalize-space()='State']/following::input[1]")WebElement billingStatebtn;
    @FindBy(xpath="//label[normalize-space()='PIN Code']/following::input[1]")WebElement billingPin;
	
    public TravelerDetailsPage(WebDriver driver) 
    {
		super(driver);
		this.driver=driver;
		
	}
	
// Clicking on continue to Pay btn ---------------------------------------
	public void continueToPay()
	{   
		
		waitUntilElementToBeClickable(ContinuePaybtn);
		ContinuePaybtn.click();
		
	}

//To check if Continue to Pay btn is enabled----------------------------------
    public boolean canProceedToPay() {
   
        waitUntilElementToBeClickable(ContinuePaybtn);
        return ContinuePaybtn.isEnabled();
    
}

//To get text after not filling traveler details---------------------------------
	public String emptyDetails()
	{
		String fillDetails=emptyName.getText();
		return fillDetails;
	}
	
//Filling traveler details-------------------------------------------------------
	public void typeDetails(String tname,String tage,String temail)
	{
		name.sendKeys(tname);
		age.sendKeys(tage);
		email.sendKeys(temail);	
		
	}

//To tick the insurance check box----------------------------------------------
	public void insuranceCheck()
	{
		waitUntilElementToBeClickable(insurancebtn);
		insurancebtn.click();
		
	}
	
//To get text of insurance check box---------------------------------------------
	public String insuranceCheckLabel()
	{
		String label=insuranceLabel.getText();
		return label;
		
	}

//Opening the billing address section---------------------------------------------
	public void billingOpen()
	{   
		waitUntilElementToBeClickable(Billingbtn);
		Billingbtn.click();
		
	}

//Closing the billing section------------------------------------------------------
	public void billingSaves()
	{
		waitUntilElementToBeClickable(Billing_save);
		Billing_save.click();
		
	}

//Entering the  state --------------------------------------------------------------
	public void selectBillingState(String state) 
	{
		waitUntilElementToBeClickable(billingStatebtn);
	    billingStatebtn.click();
	    By exactOption = By.xpath("//li[normalize-space(.)='" + state + "']");
	    wait.until(ExpectedConditions.elementToBeClickable(exactOption)).click();
	    
	}
	
//Entering the city PIN---------------------------------------------------------------
	public void enterBillingPin(String pin)
	{
		waitUntilVisibilityOfElement(billingPin);
	    billingPin.sendKeys(pin);
	}

	
	

}
