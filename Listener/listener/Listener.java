package listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import BaseClasses.Base;

public class Listener extends Base implements ITestListener
{
	
public void onTestSuccess(ITestResult result) 
{
	System.out.println(result.getName());
}
public void onTestFailure(ITestResult result) 
{
	String TCName1=result.getName();
	try {
		prepareScreenShot(TCName1);
	} 
	catch (IOException e) {
		
		e.printStackTrace();
	}
	}
public void onTestSkipped(ITestResult result) 
{
	String TCName2 = result.getName();
		try {
			prepareScreenShot(TCName2);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
