package KiteAppTest;

import org.testng.annotations.Test;

import BaseClasses.Base;
import KiteAppPomClasses.KiteHomePage;
import KiteAppPomClasses.KiteLoginPage;
import KiteAppPomClasses.KitePinPage;
import utilityPackage.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;
@Listeners(listener.Listener.class)
public class KiteAppTestClass extends Base
{
	KiteLoginPage login;
	KitePinPage pin;
	KiteHomePage home;
  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException 
  {
	 // int TCID=500;
	  String actualUserName = home.getActualUserID();
	  String expectedUserName = Utility.prepareExcel(0, 0);
	  
	  Assert.assertEquals(actualUserName, expectedUserName,"actual and expected are not matching");
	  //Utility.prepareScreenShot(driver, TCID);
  }
  @BeforeMethod
  public void loggingPage() throws EncryptedDocumentException, IOException 
  {
	 login=new KiteLoginPage(driver);
	   pin= new KitePinPage(driver);
	  home=new KiteHomePage(driver);
	  
	  login.enterUserID(Utility.prepareExcel(0, 0));
	  login.enterPassword(Utility.prepareExcel(0, 1));
	  login.clickOnLoginButton();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	  pin.enterPin(Utility.prepareExcel(0, 2));
	  pin.clickOnContinueButton();
  }

  @AfterMethod
  public void loggingOut() throws InterruptedException 
  {
	  home.clickOnLogOutButton();
  }

  @BeforeClass
  public void openBrowser() throws InterruptedException
  {
	 launchBrowser();
	 Reporter.log("open browser sucessfully",true);
  }

  @AfterClass
  public void closingBrowser()
  {
	  closeBrowser();
	  Reporter.log("clossing browser succesfully",true);
  }

  

}
