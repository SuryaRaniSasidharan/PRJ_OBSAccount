package SequentialTC;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_TestCases.POMLogin;
import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import waitUtility.WaitUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import webDriverUtility.DriverManager;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestNGLogin {
	
	public static WebDriver driver;
	static String url="https://qalegend.com/billing/public/login";
	static String Browser="Chrome";
	POMLogin objLogin;
	WaitUtility waitHandler;

    
  @Test  (priority=1,enabled=true)
  public void loginTest() throws InterruptedException, IOException {
	  
	  String excelUserName=ExcelRead.readStringData(1,0);
	  String excelpassword=ExcelRead.integerData(1, 1);
	  objLogin.loginCredentials(excelUserName, excelpassword);
	  
	  String currenturl=driver.getCurrentUrl();
	  SoftAssert Objassert=new SoftAssert();
	  Objassert.assertEquals(PropertyFileRead.readConfigFile("url"), currenturl);
      Objassert.assertAll();
      
      }
  
  @Test  (priority=2,enabled=true, groups= {"failed"})
  public void loginTestfailed() throws InterruptedException, IOException {
	  
	  String excelUserName=ExcelRead.readStringData(1,0);
	  String excelpassword=ExcelRead.integerData(1, 1);
	  objLogin.loginCredentials(excelUserName, excelpassword);
	  
	  String currenturl=driver.getCurrentUrl();
	  SoftAssert Objassert=new SoftAssert();
	  Objassert.assertEquals("123", currenturl);
	  objLogin.signout();
      Objassert.assertAll();
    
    }
 @BeforeTest(alwaysRun=true)
  
  public void beforeTest() throws InterruptedException {
	  DriverManager obj=new DriverManager();
	  obj.launchBrowser(url, Browser);
	  driver=obj.driver;
	  objLogin=new POMLogin(driver);
	  
	   }

 
  
}
