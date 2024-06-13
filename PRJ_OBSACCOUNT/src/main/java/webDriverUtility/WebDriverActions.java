package webDriverUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverActions {
	public WebDriver driver;
	private String iframe;

	public WebDriverActions(WebDriver driver) {
		this.driver = driver;

	}
	
// Functions to handle alert msg
	
    public void Alertaccept() {
		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.accept();

	}

	public void Alertdismiss() {
		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.dismiss();
	}
// Functions to handle iframe	

	public void iframes(WebElement element) {
		
		driver.switchTo().frame(element);
	}
// JavaScripExecuter
	public void javascriptTestcase(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void javascriptTCScrollPixcel(WebElement element)
	{
		JavascriptExecutor jsPixcel = (JavascriptExecutor) driver;
		jsPixcel.executeScript("window.scrollBy(0,-350)", element);
	}
	public void javascriptTCScrollElement(WebElement element)
	{
		JavascriptExecutor jsElement = (JavascriptExecutor) driver;
		jsElement.executeScript("arguments[0].scrollIntoView();", element);
	}
	

// Common method implementation for webelement

	public void click(WebElement value) {
		value.click();
	}

	public void sendkeys(WebElement value, String value1) {
		value.clear();
		value.sendKeys(value1);
	}
	public String getText(WebElement value) {
		String Value = value.getText();
		return Value;
	}
	
// To Handle DropDown
	
	public void DropdownselectByvalue(WebElement dropdown, String value) 
	{
		Select objSelect=new Select(dropdown);
		objSelect.selectByValue(value);
		
	}
    public void DropdownselectByIndex(WebElement dropdown,int value) {
	    Select objSelect = new Select(dropdown);
		objSelect.selectByIndex(value);
	 }
    
	public void DropdownselectByVisibleText(WebElement dropdown,String text) {
		Select objSelect = new Select(dropdown);
		objSelect.selectByVisibleText(text);
	}
	
    public void screenshot() throws IOException
    {
   	     Calendar cal=Calendar.getInstance(); //create an instance of calender class& getInstance() returns a Calender obj initialise with current time &date
		 Date time=cal.getTime(); //Date is class & getTime() returns a Date obj
		 String timestamp=time.toString().replace(":", "").replace(" ", ""); //covert date to string
 		 
    	 // convert web driver object to TakeScreenshot
    	 
    	 TakesScreenshot scrShot=((TakesScreenshot)(driver)); // TakesScreenshot is an interface
    	 
    	 // Call getScreeShotAs method to create image file
    	 
    	 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
    	 // Move image file to new destination
    	 
    	 File DestFile=new File("D:\\ObsquraFinalProject\\PRJ_OBSACCOUNT\\src\\test\\resources\\screenshot\\test"+timestamp+".png");
    	 
    	 // copy file at destination
    	 
         FileUtils.copyFile(SrcFile,DestFile);
		
    }



}
