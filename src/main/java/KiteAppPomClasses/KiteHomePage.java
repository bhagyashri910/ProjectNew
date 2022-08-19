package KiteAppPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class KiteHomePage 
{
@FindBy(xpath = "//span[@class='user-id']")private WebElement UserID;
@FindBy(xpath = "//a[@target='_self']")private WebElement logOut;

public KiteHomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public String getActualUserID()
{
	String actualUserId = UserID.getText();
	return actualUserId;
}
public void clickOnLogOutButton() throws InterruptedException
{
	UserID.click();
	Thread.sleep(1000);
	logOut.click();
	Reporter.log("Logout successfully");
}
}
