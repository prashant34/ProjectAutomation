package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFile {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	public ReadExcelFile(String path) 
	{
		
	 try {
		 
		File  file = new File(path);
		
		 FileInputStream inputStream = new FileInputStream(file);
		 
		 wb = new XSSFWorkbook(inputStream);
		 
		 
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
	     }
	 
	  }
	


     public String getdata(int Sheetno,int row,int col)
     {
    	 sheet1= wb.getSheetAt(Sheetno);
    	 String data= sheet1.getRow(row).getCell(col).getStringCellValue();
    	 return data;
     }
     
     public int getRowcount(int sheetindex)
     {
    	 int rowcount=  wb.getSheetAt(sheetindex).getLastRowNum();
    	  rowcount=rowcount+1;
    	  return rowcount;
     }
}

