package POM_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import waitUtility.WaitUtility;
import webDriverUtility.WebDriverActions;

public class POMCatagory {

	WebDriverActions objActions;
	WebDriver driver;
	WaitUtility waitHandler;
	
	public POMCatagory(WebDriver driver)
	{
		this.driver=driver;
		objActions=new WebDriverActions(driver);
		PageFactory.initElements(driver, this); 
	}
	

	@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[9]/a") 
	public WebElement webCatagory;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button")
	public WebElement cataoryAdd;
	
	@FindBy(xpath="//*[@id=\"name\"]")
	public WebElement catagoryName;
	
	@FindBy(xpath="//*[@id=\"short_code\"]")
	public WebElement catagoryCode;
	
	@FindBy(xpath="//*[@id=\"category_add_form\"]/div[3]/button[1]")
	public WebElement catagorySave;
	
	@FindBy(xpath="//*[@id=\"toast-container\"]/div")
	public WebElement catagoryMessage;
	
	@FindBy(xpath="//*[@id=\"category_table_filter\"]/label/input")
	public WebElement searchCatagory ;
	
	@FindBy(xpath="//*[@id=\"category_table\"]/tbody/tr[1]/td[1]")
	public WebElement searchCatagoryName ;
	
	@FindBy(xpath="//*[@id=\"category_table\"]/tbody/tr[1]/td[3]/button[2]")
	public WebElement deleteCatagoryButton;
	
	@FindBy(xpath="/html/body/div[4]/div/div[4]/div[2]/button")
	public WebElement deleteCatagory_ok;
	
	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div")
	public WebElement deleteCatagory_message;
	
	public void clickCatagory() throws InterruptedException
	{   

		 waitHandler=new WaitUtility(driver);
		  waitHandler.normalWait(2000);
		  objActions.click(webCatagory);
		  objActions.click(cataoryAdd);
		 waitHandler=new WaitUtility(driver);
		  waitHandler.normalWait(4000);
		
		
	}
	public void addCatagoryCredentials(String catagory_name,String catagory_code) throws InterruptedException
	{
		objActions.sendkeys(catagoryName, catagory_name);
		objActions.sendkeys(catagoryCode, catagory_code);
		objActions.click(catagorySave);
		 waitHandler=new WaitUtility(driver);
		 waitHandler.normalWait(4000);
		 objActions.sendkeys(searchCatagory, catagory_name);
	}
	public String get_catagoryMessage()
	{
		waitHandler.presenceOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div"), 3);
		return objActions.getText(catagoryMessage);
	
	}
	public String searchCatogory() throws InterruptedException
	{
		 waitHandler=new WaitUtility(driver);
		 waitHandler.normalWait(4000);
		return objActions.getText(searchCatagoryName);
		
		
	}
	public void deteteCatagory() throws InterruptedException
	{
		
		objActions.click(deleteCatagoryButton);
		 waitHandler=new WaitUtility(driver);
		 waitHandler.normalWait(4000);
		objActions.click(deleteCatagory_ok);
		waitHandler=new WaitUtility(driver);
	    waitHandler.normalWait(4000);
		
	}
	public String delete_catagoryMessage()
	{
		return objActions.getText(deleteCatagory_message);
	}
	

}
