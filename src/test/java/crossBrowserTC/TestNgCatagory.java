package crossBrowserTC;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_TestCases.POMCatagory;
import POM_TestCases.POMLogin;
import POM_TestCases.POMUnit;
import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import waitUtility.WaitUtility;
import webDriverUtility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestNgCatagory {
	static WebDriver driver;
	static String url="https://qalegend.com/billing/public/login";
	static String Browser="Chrome";
	POMLogin objLogin;
	POMUnit objUnit;
	POMCatagory objCatagory;
	WaitUtility waitHandler;
	
  @Test(priority=1,enabled=true, dataProvider="testdata")
  public void catagoryTest1(String unitdata1,String unitdata2) throws IOException, InterruptedException {
	  String excelUserName=ExcelRead.readStringData(1,0);
	  String excelpassword=ExcelRead.integerData(1, 1);
	  objLogin.loginCredentials(excelUserName, excelpassword);
	  objLogin.productClick();
	  
	  objCatagory=new POMCatagory(driver);
	  objCatagory.clickCatagory();
	  objCatagory.addCatagoryCredentials(unitdata1, unitdata2);
	  
	  String expecte_catagorydmessgae="Category added successfully";
	  String actual_catagorymessage=objCatagory.get_catagoryMessage();
	  System.out.println(actual_catagorymessage);
	  Assert.assertEquals(expecte_catagorydmessgae, actual_catagorymessage);
    
  }
	
	  @Test(priority=2,enabled=true)
	  public void catagoryTest2() throws InterruptedException {
	  
	  String expectedcatogory="Shoes";
	  String actualcatagory=objCatagory.searchCatogory();
	  System.out.println(actualcatagory);
	  SoftAssert unitAssert=new SoftAssert();
	  unitAssert.assertEquals(expectedcatogory, actualcatagory);
	  unitAssert.assertAll();
	  
}
	  @Test (priority=3,enabled=true)
	  public void catagoryTest3() throws InterruptedException {
		  
		  objCatagory.deteteCatagory();
		  String expected_deleteCatagory="Category deleted successfully";
		  String actual_deleteCatagory=objCatagory.delete_catagoryMessage();
		  System.out.println(actual_deleteCatagory);
		  SoftAssert unitAssert=new SoftAssert();
		  unitAssert.assertEquals(expected_deleteCatagory, actual_deleteCatagory);
		  unitAssert.assertAll();
				  
		   }
  @BeforeTest
  @Parameters({"browserTest3","urlTest3"})
  public void beforeTest(@Optional("edge")String browserTest3,String urlTest3) {
	  DriverManager obj=new DriverManager();
	  obj.launchBrowser(urlTest3,browserTest3);
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
        Object [][] catagorydata=new Object[1][2];

  // Enter data to row 0 column 0
        catagorydata[0][0]="Shoes";
  // Enter data to row 0 column 1
        catagorydata[0][1]="srs";
         return catagorydata;
  }


}
