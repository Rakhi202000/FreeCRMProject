package com.LiveSafe.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import com.LiveSafe.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 20;
	static Workbook book;
	static Sheet sheet;
	static String TESTDATA_SHEET_PATH ="C:\\Users\\rmodi\\eclipse-workspace\\FreeCRMSelenium\\FreeCRMSelenium\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";



	public static Object [] [] getTestData(String sheetName){

		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(TESTDATA_SHEET_PATH);
			book = WorkbookFactory.create(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// read the sheet inside the workbook by its name
		sheet = (Sheet) book.getSheet(sheetName);


		Object [] [] value = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=1; i < sheet.getLastRowNum(); i++)
		{ 
			for(int j =0; j < sheet.getRow(0).getLastCellNum(); j++) {
				value[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return value;
	}

}
