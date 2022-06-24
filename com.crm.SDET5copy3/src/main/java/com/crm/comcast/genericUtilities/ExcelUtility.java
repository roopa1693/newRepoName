package com.crm.comcast.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtility {
	
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Throwable 
	 */
	public String getExcelCellValue(String sheetName,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.exPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row1=sheet.getRow(row);
		Cell cell1 = row1.getCell(cell);
		DataFormatter data1=new DataFormatter();
		String value = data1.formatCellValue(cell1);
		return value;
	}
	/**
	 * it will set status in excel sheet..
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param status
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setExcelCellValue(String sheetName,int row,int cell,String status) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis=new FileInputStream(IPathConstants.exPath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(status);
	}
}
