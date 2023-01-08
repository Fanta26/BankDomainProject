package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	//this method is use to get PF data
	//need to pass String key & return String value
	//Author name: @Anup
	public static String readPFData(String key) throws IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\Desktop\\AUTOMATION Testing notes\\30July_Maven\\PropertyFile.properties");
		
		Properties p=new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		return value;
	}
	
	
	//this method is use to capture screenshot on webpage
	//need to pass 2 inputs:  1.webDriver object   2.TCID
	//Author Name: @Anup 
	public static void captureSS(WebDriver driver,int TCID) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Admin\\Desktop\\AUTOMATION Testing notes\\30July_Maven\\FailedTCesSS\\TestCaseID"+ TCID+  ".jpg");
		FileHandler.copy(src, dest);
	}
	
	
	//this method is use to get test data from excel sheet
	//need to pass 2 inputs:  1.rowIndex   2.cellIndex
	//Author Name: @Anup 
	public static String getTD(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\Desktop\\AUTOMATION Testing notes\\30July_Maven\\TestData\\30JulyEve.xlsx");
		 Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		 String value = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		 return value;
	}
	
	//this method is use to get test data from excel sheet
	//need to pass 3 inputs:  1.rowIndex   2.cellIndex 3. sheetName
	//Author Name: @Anup 
	public static String getTD(int rowIndex, int cellIndex,String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\Desktop\\AUTOMATION Testing notes\\30July_Maven\\TestData\\30JulyEve.xlsx");
		 Sheet sh = WorkbookFactory.create(file).getSheet(sheetName);
		 String value = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		 return value;
	}

}
