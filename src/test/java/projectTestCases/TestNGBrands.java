package projectTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_TestCases.POMBrands;
import POM_TestCases.POMCatagory;
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

public class TestNGBrands {
	static WebDriver driver;
	static String url="https://qalegend.com/billing/public/login";
	static String Browser="Chrome";
	POMLogin objLogin;
	POMBrands objBrands;
	WaitUtility waitHandler;
	
  @Test(priority=1,enabled=true, dataProvider="testdata")
  public void brandTest1(String unitdata1,String unitdata2) throws IOException, InterruptedException {
	  String excelUserName=ExcelRead.readStringData(1,0);
	  String excelpassword=ExcelRead.integerData(1, 1);
	  objLogin.loginCredentials(excelUserName, excelpassword);
	  objLogin.productClick();
	  
	  objBrands=new POMBrands(driver);
	  objBrands.clickBrand();
	  objBrands.addBrandsCredentials(unitdata1, unitdata2);
  
	  String expectedmessgae="Brand added successfully";
	  String actualmessage=objBrands.get_brandMessage();
	  System.out.println(actualmessage);
	  Assert.assertEquals(expectedmessgae, actualmessage );
  }
	  @Test(priority=2,enabled=true)
	  public void brandTest2() throws InterruptedException {
		  objBrands.searchBrand("Puma"); 
		  String expectedbrand="Puma";
		  String actualbrand=objBrands.getBrandName();
		  System.out.println(actualbrand);
		  SoftAssert unitAssert=new SoftAssert();
		  unitAssert.assertEquals(expectedbrand, actualbrand);
		  unitAssert.assertAll();
	  
	  }
 
  @BeforeTest
  public void beforeTest() {
	  DriverManager obj=new DriverManager();
	  obj.launchBrowser(url, Browser);
	  driver=obj.driver;
	  objLogin=new POMLogin(driver);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  
  @DataProvider(name="testdata")
  public Object[][] TestDataFeed(){

  // Create object array with 2 rows and 2 column- first parameter is row and second is //column
  Object [][] branddata=new Object[1][2];

  // Enter data to row 0 column 0
  branddata[0][0]="Puma";
  // Enter data to row 0 column 1
  branddata[0][1]="pma";
  return branddata;
  }

}
