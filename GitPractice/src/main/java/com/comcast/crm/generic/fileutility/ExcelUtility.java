package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

 public String getDataFromExcel(String sheetname,int rowno,int cellno) throws Throwable
	{
	   FileInputStream fis=new FileInputStream("./src/test/resources/TestscriptDataforutility.xlsx");
	   Workbook wb=WorkbookFactory.create(fis);
	   Sheet  sheet=wb.getSheet(sheetname);
	   Row row=sheet.getRow(rowno);
	   String data=row.getCell(cellno).getStringCellValue();
	   wb.close();
	   return data;
	}
	
 public int getRowCount(String sheetname) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestscriptDataforutility.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet  sheet=wb.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		wb.close();
		return rowcount;
	}
 public String setDataIntoExcel(String sheetname,int rowno,int cellno,String data) throws Throwable
 {
	 FileInputStream fis=new FileInputStream("./src/test/resources/TestscriptDataforutility.xlsx");
	 Workbook wb=WorkbookFactory.create(fis);
	 Sheet sheet=wb.getSheet(sheetname);
	 Row row= sheet.getRow(rowno);
     Cell cell= row.createCell(cellno);
     cell.setCellValue(data);
     FileOutputStream fos=new FileOutputStream("./src/test/resources/TestscriptDataforutility.xlsx");
	 wb.write(fos);
	 wb.close();
	 return data;
 }
}
