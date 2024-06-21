package parallelTC;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import POM_TestCases.POMLogin;
import POM_TestCases.POMUnit;
import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import extendReport.ExtendTestManager;
import waitUtility.WaitUtility;
import webDriverUtility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestNgUnit extends ExtendTestManager {
	
	static WebDriver driver;
	static String url="https://qalegend.com/billing/public/login";
	static String Browser="Chrome";
	POMLogin objLogin;
	POMUnit objUnit;
	WaitUtility waitHandler;
	
	ExtentTest test;
	public ExtentReports extent;
	ExtendTestManager objTestManager;
	
	 @Test (priority=1, enabled=true, dataProvider="testdata")
	  public void unitTest1(String unitdata1,String unitdata2) throws IOException, InterruptedException {
		
	  test=extent.createTest("Validating unit scenario");
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
      
      
	  objLogin.productClick();
	  
	  objUnit=new POMUnit(driver);
	  objUnit.unitCredentials();
      objUnit.addCredentials(unitdata1,unitdata2 );
     
 
	  String expectedmessgae="Unit added successfully";
	  String actualmessage=objUnit.getMessage();
	  System.out.println(actualmessage);
	  Assert.assertEquals(expectedmessgae, actualmessage );
	  
}
		
	  @Test (priority=2,enabled=true)
	  public void unitTest2() throws InterruptedException {
		  
	  objUnit.search("Surya_unit");  
	  String expectedname="Surya_unit";
	  String actualname=objUnit.getName();
	  System.out.println(actualname);
	  SoftAssert unitAssert=new SoftAssert();
	  unitAssert.assertEquals(expectedname, actualname);
	  unitAssert.assertAll();
	  }
	  
	  @Test (priority=3,enabled=true)
	  public void unitTest3() throws InterruptedException {
		  
		  objUnit.deteteName();
		  String expected_deleteUnit="Unit deleted successfully";
		  String actual_deleteUnit=objUnit.delete_unitMessage();
		  System.out.println(actual_deleteUnit);
		  SoftAssert unitAssert=new SoftAssert();
		  unitAssert.assertEquals(expected_deleteUnit, actual_deleteUnit);
		  unitAssert.assertAll();
				  
		   }
	  @BeforeTest
	  
	  public void beforeTest() throws InterruptedException {
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
  @DataProvider(name="testdata")
  public Object[][] TestDataFeed(){

  // Create object array with 2 rows and 2 column- first parameter is row and second is //column
        Object [][] unitdata=new Object[1][2];

  // Enter data to row 0 column 0
        unitdata[0][0]="Surya_unit";
  // Enter data to row 0 column 1
        unitdata[0][1]="s_unit";
         return unitdata;
  }



}
