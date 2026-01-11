package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
		private final Properties props = new Properties();
		 
		public PropertyReader() 
		{
		     try (FileInputStream fis = new FileInputStream("src\\test\\resource\\PropertiesFiles\\Bus.properties"))
		     {
		         props.load(fis);
		     } 
		     catch (IOException e) 
		     {
		         throw new RuntimeException("Unable to load makemytrip.properties", e);
		     }
		}
		
//Get method used to pass the values from .properties file-------------------------------------
		public String get(String key) 
		{
		     return props.getProperty(key);
		}
	

}
