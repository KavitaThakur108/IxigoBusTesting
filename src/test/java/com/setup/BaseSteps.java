package com.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.parameters.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {
	public static WebDriver driver;
	public static EdgeOptions eoptions;
	public static ChromeOptions coptions;
	public static PropertyReader property;
	
//---------------------Constructor-----------------------------------------------
	public BaseSteps()
	{
		 property = new PropertyReader();
	}
	
	
//---------------------Cross Browser(used .properties file )---------------------------------------------
	
	public static WebDriver getDriver()
	{    
		//Trying to take the value from JVm by default,but if its Null,consider the value that we passed using .properies file
		 String browser = System.getProperty("browser",property.get("browser"));

         if (browser.equalsIgnoreCase("chrome")) 
         {
            return chromedriver();
         } 
         else if (browser.equalsIgnoreCase("edge") ) 
         {
            return edgedriver();
         }
         else
         {   //if unknown ,then consider By default edge Browser
        	 System.out.println("[BaseSteps] Unknown browser: " + browser );
        	 return edgedriver();
         }
	}
	
	
//-------------------Running tests on Chrome--------------------------------------
	
	
	
	
	public static WebDriver chromedriver()
	{
		WebDriverManager.chromedriver().setup();
		coptions = new ChromeOptions();
		property = new PropertyReader();
		coptions.addArguments(property.get("maximised"));
		coptions.addArguments(property.get("mode"));
		coptions.addArguments(property.get("denyPermission"));
		coptions.addArguments(property.get("notification"));
		coptions.addArguments(property.get("popup"));
		driver = new ChromeDriver(coptions);
		String URL=property.get("base.URL");
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
	}

	
//------------------Running tests on Edge------------------------------------------------------
	public static WebDriver edgedriver()
	{
		WebDriverManager.edgedriver().setup();
		eoptions = new EdgeOptions();
		property = new PropertyReader();
		eoptions.addArguments(property.get("maximised"));
		eoptions.addArguments(property.get("mode"));
		eoptions.addArguments(property.get("denyPermission"));
		eoptions.addArguments(property.get("notification"));
		eoptions.addArguments(property.get("popup"));
		
		driver = new EdgeDriver(eoptions);
		String URL=property.get("base.URL");
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
	}


}
