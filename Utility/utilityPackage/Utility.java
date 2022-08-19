package utilityPackage;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
public static String prepareExcel(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
{
	FileInputStream myFile=new FileInputStream("D:\\SELENIUM folder of SW\\excelTest.xlsx");
	Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet14");
	String value = mySheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
	return value;
}

}
