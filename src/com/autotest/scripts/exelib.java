package com.autotest.scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.autotest.master.library;

public class exelib extends library{
	static WebDriver driver;
	static FileInputStream fis1;
	static Properties pr;
	
	
public static void main(String[] args) throws Throwable {
		library libr1=new library();
		libr1.open("https://www.amazon.com/");
		libr1.login("seltesterautomation@gmail.com","Zenqtest123");
		libr1.crtlst("list1");
		
	fis1=new FileInputStream("C:\\Users\\shravan\\Desktop\\workbench\\autotest\\src\\com\\autotest\\testdata\\clist.xlsx");
	
					XSSFWorkbook Wb=new XSSFWorkbook(fis1);
				   XSSFSheet Ws=Wb.getSheet("Sheet1");
					int Rcount=Ws.getLastRowNum();
				     System.out.println(Rcount);
				  
				     for (int i=1;i<=Rcount;i++) 
				     {
				     
				    	 XSSFRow Wr=Ws.getRow(i);
				    	 XSSFCell Wc=Wr.getCell(0);
				        String clist=Wc.getStringCellValue();
				         String res=libr1.addlist(clist);
				 
				     }
 libr1.accountaddr();
 libr1.signout();
				
}
}
