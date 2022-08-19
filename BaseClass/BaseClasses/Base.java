package BaseClasses;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
public class Base
{
     protected static WebDriver driver;
	public void launchBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM folder of SW\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.get("https://kite.zerodha.com/");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	Reporter.log("launch browser successfully",true);
}
	public void closeBrowser()
	{
		driver.close();
		Reporter.log("closed browser successfully",true);
	}
	public void prepareScreenShot(String TCName) throws IOException
	{ 
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("D:\\Myscreenshot\\TC"+TCName+"screenShot.png");
		FileHandler.copy(source, destination);
	}
}
