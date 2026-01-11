package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
     
//----------------Reading Excel For Scenerio Outline((Insurance)2,(Defect)3)---------------------------
	public String[] getTravelerDetails(String filename,int sheetno,int rowno) throws IOException
	{
		//opens the file
		FileInputStream fis=new FileInputStream("src\\test\\resource\\ExcelData\\"+filename);
		//load the workbook
		XSSFWorkbook work=new XSSFWorkbook(fis);
		XSSFSheet sheet=work.getSheetAt(sheetno);
		XSSFRow row=sheet.getRow(rowno);
		
		XSSFCell name=row.getCell(0); 
		XSSFCell age=row.getCell(1);
		XSSFCell email=row.getCell(2);
		
		String[]data=new String[3];
		
		data[0]=name.getStringCellValue();
 	    //getting numeric value from Excel and converting into String
		double ageNum = age.getNumericCellValue();  
		data[1] = String.valueOf((int) ageNum); 
        
		data[2]=email.getStringCellValue();
		
		return data;
		
	}
//----------------Reading Excel for Datatable(Scenerio (defect)3,(creditCard details)6)------------------------------------
	public String[] TravelDetailsReader(String filename) throws IOException
	{
		String filepath="src\\test\\resource\\ExcelData\\"+filename;
		String[] details=new String[3];
		FileInputStream fis=new FileInputStream(filepath);
		XSSFWorkbook work=new XSSFWorkbook(fis);
		Sheet sheet=work.getSheetAt(1);
		
		details[0]=sheet.getRow(1).getCell(0).getStringCellValue();
		//getting numeric value from Excel and converting into String
		double ageNum = sheet.getRow(1).getCell(1).getNumericCellValue();  // throws if not numeric
		details[1] = String.valueOf((int) ageNum); 

		details[2]=sheet.getRow(1).getCell(2).getStringCellValue();
		
		return details;
		
	}
}
