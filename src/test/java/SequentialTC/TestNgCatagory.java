package SequentialTC;

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
	TestNGLogin objTestLogin;
	
  @Test(priority=1,enabled=true)
  public void f() throws IOException, InterruptedException {
	   objTestLogin=new TestNGLogin();
       objCatagory=new POMCatagory(objTestLogin.driver);

	  objCatagory.clickCatagory();
	  objCatagory.addCatagoryCredentials("Shoes", "srs");
	  
	  String expecte_catagorydmessgae="Category added successfully";
	  String actual_catagorymessage=objCatagory.get_catagoryMessage();
	  System.out.println(actual_catagorymessage);
	  Assert.assertEquals(expecte_catagorydmessgae, actual_catagorymessage);
	  
      
  }
	
	  @Test(priority=2,enabled=true)
	  public void f2() throws InterruptedException {
	  
	  String expectedcatogory="Shoes";
	  String actualcatagory=objCatagory.searchCatogory();
	  System.out.println(actualcatagory);
	  SoftAssert unitAssert=new SoftAssert();
	  unitAssert.assertEquals(expectedcatogory, actualcatagory);
	  unitAssert.assertAll();
	  
	}
	  @Test (priority=3,enabled=true)
	  public void f3() throws InterruptedException {
		  
		  objCatagory.deteteCatagory();
		  String expected_deleteCatagory="Category deleted successfully";
		  String actual_deleteCatagory=objCatagory.delete_catagoryMessage();
		  System.out.println(actual_deleteCatagory);
		  SoftAssert unitAssert=new SoftAssert();
		  unitAssert.assertEquals(expected_deleteCatagory, actual_deleteCatagory);
		  unitAssert.assertAll();
				  
		   }


}
