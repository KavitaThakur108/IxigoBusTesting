package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeatBookingPage extends BasePage{
	
	
	 By ssoFrameBy = By.id("sso-frame");
		

	
	//----finding list of buses
	
	@FindBy(css="div[id^='service-'].service, div.bus-card, li.bus-item")List<WebElement> Buses;
	@FindBy(xpath="//span[text()=\"U21\"]")WebElement seatSelect;
	@FindBy(xpath="//p[text()='SIRUSERI']")WebElement Boardingpoint;
	@FindBy(xpath="//p[text()='chityala']")WebElement Droppingpoint;
	@FindBy(xpath="//span[text()=\"Continue\"]")WebElement Continuebtn;
	

	  
    By SHOW_SEATS_IN_CARD = By.xpath(".//button[normalize-space()='Show Seats' or normalize-space()='View Seats' or contains(.,'Seats')]");

	
//----------CONSTRUCTOR------------
	public SeatBookingPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
	}
	
	
	
//----------Select seat--------------	
	public void selectSeat() 
	{
		driver.switchTo().defaultContent();
		//Ensuring the overlay is gone 
		waitUntilOverlayGone(ssoFrameBy, Duration.ofSeconds(10));
        //By locator - 	POM is used for dynamic handling(wait for all the buses to load)
		By serviceCard=By.cssSelector("div[id^='service-'].service");
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(serviceCard));

        //Selecting first bus
        WebElement firstcard=Buses.get(0);
        scrollIntoView(firstcard);
        action.moveToElement(firstcard).pause(Duration.ofMillis(150)).build().perform();
        
        //Clicking on the (show seat) btn of first bus card
        List<WebElement> buttons = firstcard.findElements(SHOW_SEATS_IN_CARD);
        WebElement showSeatsBtn = buttons.get(0);
		waitUntilVisibilityOfElement(showSeatsBtn);
		action.moveToElement(showSeatsBtn).click().perform();
		
		//Selecting your particular seat
		waitUntilVisibilityOfElement(seatSelect);
		waitUntilElementToBeClickable(seatSelect);
		action.moveToElement(seatSelect).click().perform();
		
		
	}
	
//---------Select Boarding/ dropping point----------
	public void selectBoardingDropping()
	{
		waitUntilElementToBeClickable(Boardingpoint);
		Boardingpoint.click();
		waitUntilElementToBeClickable(Droppingpoint);
		Droppingpoint.click();
		
	}
//-------- Seat Booking Confirm and continue------------------
	public void seatContinue()
	{
		waitUntilElementToBeClickable(Continuebtn);
		Continuebtn.click();
		
	}

	
}
