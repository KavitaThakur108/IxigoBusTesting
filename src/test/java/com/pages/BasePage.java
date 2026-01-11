package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.PropertyReader;

public class BasePage {
	
	//Objects
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	JavascriptExecutor js;
	Alert alert;
	PropertyReader propertyReader;

	
	//constructor
	public BasePage(WebDriver driver)
	{
		 this.driver=driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 this.action = new Actions(driver);
         PageFactory.initElements( driver,this);
		 js = (JavascriptExecutor) driver;
		 propertyReader = new PropertyReader();
	
		
	}
	
	
	
//---------Wait for the button to get clickable-----------------
	
	public void waitUntilElementToBeClickable(WebElement element)
	{

		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		 
		
	}
	
//---------------wait to visible the element-----------------------
	public void waitUntilVisibilityOfElement(WebElement element)
	{
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(element));
	}
	

//--------------switch to I frame-----------------------------------
	public void switchToIframe(By ssoFrameBy) 
	{  
	    driver.switchTo().defaultContent();
	    wait= new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ssoFrameBy));
	}

//------------switch to default URL--------------------------------------------
	public void switchToDefaultContent() 
	{
	     driver.switchTo().defaultContent();
	}
//-------------Javascript to scroll the view------------------------------------

    public void scrollIntoView(WebElement element) 
    {
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", element);
    }

//---------------Javascript to click the element--------------------------------------
    public void jsClick(WebElement element) 
    {
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    
//---------------- Hide (not remove) overlay to avoid breaking app logic ---------------
    public void hideOverlay(WebElement overlay) 
    {
         ((JavascriptExecutor) driver).executeScript(
            "arguments[0].style.setProperty('display','none','important'); arguments[0].style.pointerEvents='none';",
            overlay
          );
    }
    

//-------------------- Remove an element entirely (use carefully) ----------------------
     public void removeElement(WebElement element)
    {
         ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", element);
    }
    
     
     

//---------------------Applying wait until overlay is gone-------------------------------

    public void waitUntilOverlayGone(By locator, Duration timeout) 
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(d -> {
         try
         {
            List<WebElement> elements = d.findElements(locator);
            if (elements.isEmpty()) 
            {
                return true; // Overlay not present
            }
            // If present, check if it's displayed
            return !elements.get(0).isDisplayed();
         } 
         catch (StaleElementReferenceException e) 
         {
            return true; // Element went stale, treat as gone
         }
          });
    }

//-----------------Switch to window---------------------
    
    public void getWindow() 
    {

   	   String parentHandle = driver.getWindowHandle();
	   for (String handle : driver.getWindowHandles()) 
	   {
         if (!handle.equals(parentHandle)) 
         {
            driver.switchTo().window(handle);
            break;          
	
         }
 
       }
		
     }
//----------------Alerts--------------------------------

     public Alert waitForAlert()
        {
            WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return localWait.until(ExpectedConditions.alertIsPresent());
        }
     
//-------------Get text on Alerts--------------------------
     public String getAlertText() 
       {
           Alert alert = waitForAlert();
           return alert.getText();
       }
     
     




}

     
 





