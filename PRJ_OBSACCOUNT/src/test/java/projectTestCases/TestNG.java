package projectTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_TestCases.POMLogin;
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

public class TestNG {
	
	static WebDriver driver;
	static String url="https://qalegend.com/billing/public/login";
	static String Browser="Chrome";
	POMLogin objLogin;
	WaitUtility utilityHandler;

    
  @Test  
  public void loginTest() throws InterruptedException, IOException {
	  
	  String excelUserName=ExcelRead.readStringData(1,0);
	  String excelpassword=ExcelRead.integerData(1, 1);
	  objLogin.loginCredentials(excelUserName, excelpassword);
	  objLogin.loginButton();
	  utilityHandler=new WaitUtility(driver);
	  utilityHandler.normalWait(2000);
	  
	  String url="https://qalegend.com/billing/public/home";
	  String currenturl=driver.getCurrentUrl();
	  SoftAssert Objassert=new SoftAssert();
	  Objassert.assertEquals(url, currenturl);
    	Objassert.assertAll();
	  Objassert.assertAll();
	  
	 // Assert.assertFalse(currenturl.contains(url));
	}
	  
	  
	  
	  
	  
	  
	  
  @BeforeTest
  //@Parameters({"urlTest1","browserTest1"})
  public void beforeTest() throws InterruptedException {
	  DriverManager obj=new DriverManager();
	  obj.launchBrowser(url, Browser);
	  driver=obj.driver;
//	  utilityHandler=new WaitUtility(driver);
//	  utilityHandler.normalWait(4000);
	  objLogin=new POMLogin(driver);
	  
	  
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }
  


}
