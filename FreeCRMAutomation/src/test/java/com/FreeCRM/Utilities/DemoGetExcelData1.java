package com.FreeCRM.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DemoGetExcelData1 {

	public String getExcelData(String sheetName, int row, int col)  {
		// TODO Auto-generated method stub
		String retVal= null;
		
			try {
				FileInputStream fis= new FileInputStream("./TestData/Data.xlsx");
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s=wb.getSheet(sheetName);
				retVal =s.getRow(row).getCell(col).getStringCellValue();
				
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return retVal;

	}

}
