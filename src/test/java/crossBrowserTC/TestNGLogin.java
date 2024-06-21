package crossBrowserTC;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import POM_TestCases.POMLogin;
import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import extendReport.ExtendTestManager;
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

public class TestNGLogin extends ExtendTestManager{
	
	public static WebDriver driver;
	static String url="https://qalegend.com/billing/public/login";
	static String Browser="Chrome";
	POMLogin objLogin;
	WaitUtility waitHandler;
	
	ExtentTest test;
	public ExtentReports extent;
	ExtendTestManager objTestManager;

    
  @Test  (priority=1,enabled=true)
  public void loginTest() throws InterruptedException, IOException {
	  
	  test=extent.createTest("Validating login scenario");
	  boolean Status;
	  
	  String excelUserName=ExcelRead.readStringData(1,0);
	  String excelpassword=ExcelRead.integerData(1, 1);
	  objLogin.loginCredentials(excelUserName, excelpassword);
	  
	  String currenturl=driver.getCurrentUrl();
	  SoftAssert Objassert=new SoftAssert();
	  if(PropertyFileRead.readConfigFile("url").contains(currenturl))
	  {
		  Objassert.assertTrue(true);
		  Status=true;
	  }
	  else {
		  Objassert.assertTrue(false);
		  Status=false;
		  }
	
      Objassert.assertAll();
      if(Status==true)
      {
      test.log(com.aventstack.extentreports.Status.PASS, "Login successfully to the application");

      }
      else if(Status==false) {
      test.log(com.aventstack.extentreports.Status.FAIL,"Login failed");
      }
      
      }
 @BeforeTest
 @Parameters({"browser","url"})
  public void beforeTest(@Optional("chrome")String browser,String url) throws InterruptedException {
	  DriverManager obj=new DriverManager();
	  obj.launchBrowser(url, Browser);
	  driver=obj.driver;
	  objLogin=new POMLogin(driver);
	  objTestManager=new ExtendTestManager();
	  extent=objTestManager.extendreportgenerate();
	  
	   }
 @AfterTest
 public void afterTest() {
      driver.close();
 }
 
  
}
