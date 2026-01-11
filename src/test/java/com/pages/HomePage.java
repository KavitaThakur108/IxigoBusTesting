package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Local;

public class HomePage  extends BasePage{
	

	
	
	@FindBy(xpath="//p[normalize-space()='Buses']/ancestor::*[self::a or self::button][1]")WebElement Bus;
	@FindBy(css  ="input[placeholder=\"From Station\"]")WebElement fromCity;
	@FindBy(xpath="//input[@type='text' and @placeholder='To Station']")WebElement toCity;
	@FindBy(css  ="li[data-id=\"6 Chennai (Tamil Nadu)\"]")WebElement fromCitydrop;
	@FindBy(css  ="li[data-id=\"Hyderabad\"]")WebElement toCitydrop;
	@FindBy(xpath="//button[text()=\"Search\"]")WebElement Search;
	@FindBy(xpath="//button[text()=\"Tomorrow\"]")WebElement tomorrow;
	@FindBy(xpath="//p//a[@href=\"https://www.abhibus.com/\" or text()=\"bus booking\"]")WebElement BusBookinglink;
	
//-----------------------------------------
	 By ssoFrameBy = By.id("sso-frame");
	
	
//----CONSTRUCTOR--------------------------------------------------
	public HomePage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		
	}
	
//---------Select BUS Module-------------------------------------------------------------
	
	public void busClick()
	
	{  
		//used the methods from BasePage(javaScriptExecutor)
		scrollIntoView(Bus);
		jsClick(Bus);

        switchToIframe(ssoFrameBy);
		
    }
	
	
//----------Select FROMCITY(actions)-----------------------------------------------------------	
	
	public void fromCity() 
	{ 
		waitUntilElementToBeClickable(fromCity);
		fromCity.click();
     	fromCity.clear();
		fromCity.sendKeys(propertyReader.get("fromCity.value"));
		waitUntilVisibilityOfElement(fromCitydrop);
		waitUntilElementToBeClickable(fromCitydrop);
    	action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
//------------Select TOCITY-------------------------------------------------------------
	
	public void toCity()
	{

		waitUntilElementToBeClickable(toCity);
		toCity.click();
     	toCity.clear();		
		toCity.sendKeys(propertyReader.get("toCity.value"));
		waitUntilVisibilityOfElement(toCitydrop);
		waitUntilElementToBeClickable(toCitydrop);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
//-----------Clicking on Tomorrow----------------------------------------------------
	public void tommorow()
	{
		waitUntilElementToBeClickable(tomorrow);
		tomorrow.click();
	}
	
//-----------Clicking on Bus Booking link under Top Tourist Bus Routes--------------------
	
	public void busBookinglink()
	{
		scrollIntoView(BusBookinglink);
		waitUntilVisibilityOfElement(BusBookinglink);
		waitUntilElementToBeClickable(BusBookinglink);
		BusBookinglink.click();
		
		
	}
//-------------DatePicker---------------------------------------------------------------------
	
	
	public void datePick()
	{
	   //Clicking on date input----------------------------------------------------------------
       By dateTrip=By.xpath("//input[@placeholder=\"Onward Journey Date\"]");
	   WebElement dateClick = wait.until(ExpectedConditions.elementToBeClickable(dateTrip));
	   jsClick(dateClick);
	   
	   //Find the target date by using LOcalDate class------------------------------------------
	   LocalDate targetDate = LocalDate.now().plusDays(30);
       
	   //Getting day ,month,year from targetDate and storing it------------------------------------
       String day = String.valueOf(targetDate.getDayOfMonth());
       String month = String.valueOf(targetDate.getMonthValue());
       String year = String.valueOf(targetDate.getYear());
       String MonthName=targetDate.getMonth().name();
       
       //Get the header Month from calender(January 2026--->January)---------------------------------------------------------
       By headerMonth=By.xpath("//div[@class=\"container month \"]/div[2]/span[1]");
       WebElement headerMon=wait.until(ExpectedConditions.presenceOfElementLocated(headerMonth));
       
      
       //Get the header Year from calender(January 2026--->2026)---------------------------------------------------------
       By headerYear=By.xpath("//div[@class=\"container month \"]/div[2]/span[2]");
       WebElement headery=wait.until(ExpectedConditions.presenceOfElementLocated(headerYear));
       
       
       //Finding path for next button(There were two buttons)--------------------------------------------------------------
       List<WebElement>Btns = driver.findElements(By.xpath("//div[@class='container month ']/div[2]/span[2]"));
       WebElement NextBtn = Btns.get(1); // index starts at 0
      
       
       //Clicking on next Button until the header get matched with target month and year--------------
       while(!headery.getText().equalsIgnoreCase(year) &&  !headerMon.getText().equalsIgnoreCase(MonthName))
       {
    	   waitUntilElementToBeClickable(NextBtn);
    	   NextBtn.click();
       }
 
       //Finally clicking on the target date(Now it Will be visible in DOM)-----------------------------------------------------------
       WebElement dateElement = driver.findElement(By.cssSelector("span[data-date='" + day + "'][data-month='" + month + "'][data-year='" + year + "']"));
       dateElement.click();
     
	}
	
}



