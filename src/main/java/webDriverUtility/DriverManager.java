package webDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	public WebDriver driver;
	
	public void launchBrowser(String url,String Browser)
	{
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		if(Browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		if(Browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void closeBrowser()
	{
		driver.close();   
	}
	public WebDriver driver()
	{
		return driver;
		
	}
//	   public void screenshot(String value) throws IOException
//	    {
//		   
//			   TakesScreenshot scrShot = ((TakesScreenshot) driver);
//			   LocalDateTime myDateObj = LocalDateTime.now();
//			   DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH_mm_ss");
//			   String formattedDate = myDateObj.format(myFormatObj);
//			   File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//			   File DestFile = new File(  System.getProperty("user.dir")+ "\\src\\test\\resources\\screenshot\\test" +value+ formattedDate +".png");
//
//			   // Copy file at destination
//			   FileUtils.copyFile(SrcFile, DestFile);
//			
//	    }

}
