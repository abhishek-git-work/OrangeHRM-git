package com.OrangeHRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelMethod {
	
	public static Object[][] testDataFromExcelSheet(String sheetname) throws IOException
	{
		File filepath = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\OrangeHRM\\TestData\\OrangeHRM-ExcelData.xlsx");
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		
		int rows = sheet.getLastRowNum();
		int comn = sheet.getRow(0).getLastCellNum();
		
		Object [][] data = new Object [rows][comn] ;
		
		for (int i=0; i<rows; i++)
		{
			XSSFRow row = sheet.getRow(i+1);
			
			for (int j=0; j<comn; j++)
			{
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				
				switch (celltype)
				{
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
			
		
	}

}
