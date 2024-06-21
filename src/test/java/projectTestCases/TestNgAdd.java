package projectTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_TestCases.POMAddProduct;
import POM_TestCases.POMLogin;
import POM_TestCases.POMUnit;
import excelUtility.ExcelRead;
import waitUtility.WaitUtility;
import webDriverUtility.DriverManager;

public class TestNgAdd {
	static WebDriver driver;
	static String url="https://qalegend.com/billing/public/login";
	static String Browser="Chrome";
	POMLogin objLogin;
	POMAddProduct objAdd;
	WaitUtility waitHandler;
  @Test(priority=1,enabled=true)
  public void addProduct1() throws IOException, InterruptedException {
	  String excelUserName=ExcelRead.readStringData(1,0);
	  String excelpassword=ExcelRead.integerData(1, 1);
	  objLogin.loginCredentials(excelUserName, excelpassword);
	  objLogin.productClick();
	  
	  objAdd=new POMAddProduct(driver);
	  objAdd.click_addProdct();
	  objAdd.product();
	  
	  String expected_msg="Product added successfully";
	  String actual_msg=objAdd.getText();
	  System.out.println(actual_msg);
	  SoftAssert addAssert=new SoftAssert();
	  addAssert.assertTrue(expected_msg.contains(actual_msg));
	  addAssert.assertAll();
	 
	  
	  
	
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
  
}
