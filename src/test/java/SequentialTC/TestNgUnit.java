package SequentialTC;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_TestCases.POMLogin;
import POM_TestCases.POMUnit;
import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import waitUtility.WaitUtility;
import webDriverUtility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestNgUnit {
	
	static WebDriver driver;
	static String url="https://qalegend.com/billing/public/login";
	static String Browser="Chrome";
	POMLogin objLogin;
	POMUnit objUnit;
	WaitUtility waitHandler;
	
  @Test (priority=1, enabled=true, dataProvider="testdata")
  public void unitTest1(String unitdata1,String unitdata2) throws IOException, InterruptedException {

	  
	  TestNGLogin objTestLogin=new TestNGLogin();
	  
	  objLogin=new POMLogin(objTestLogin.driver);
	  objLogin.productClick();
      objUnit=new POMUnit(objTestLogin.driver);
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
	  @DataProvider(name="testdata")
	  public Object[][] TestDataFeed(){

	  // Create object array with 2 rows and 2 column- first parameter is row and second is //column
	  Object [][] twitterdata=new Object[1][2];

	  // Enter data to row 0 column 0
	  twitterdata[0][0]="Surya_unit";
	  // Enter data to row 0 column 1
	  twitterdata[0][1]="s_unit";
	  return twitterdata;
	  }
  




}
