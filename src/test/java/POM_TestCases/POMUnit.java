package POM_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import waitUtility.WaitUtility;
import webDriverUtility.WebDriverActions;

public class POMUnit {
	
	
	WebDriverActions objActions;
	WebDriver driver;
	WaitUtility waitHandler;
	
	public POMUnit(WebDriver driver)
	{
		this.driver=driver;
		objActions=new WebDriverActions(driver);
		PageFactory.initElements(driver, this); 
	}
	
	
	@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[8]/a")
	public WebElement webUnit;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-block')]")
	public WebElement webAdd;
	
	@FindBy(xpath="//*[@id=\"actual_name\"]")
	public WebElement webName;
	
	@FindBy(xpath="//*[@id=\"short_name\"]")
	public WebElement webshortName;
	
	@FindBy(xpath="//*[@id=\"allow_decimal\"]")
	public WebElement webAllowDecimal;
	
	@FindBy(xpath="//*[@id=\"unit_add_form\"]/div[3]/button[1]")
	public WebElement webSave;
	
	@FindBy(xpath="//*[@id=\"toast-container\"]/div")
	public WebElement webMessage;
	
	@FindBy(xpath="//*[@id=\"unit_table_filter\"]/label/input")
	public WebElement search;
	
	@FindBy(xpath="//*[@id=\"unit_table\"]/tbody/tr/td[1]") 
	public WebElement searchName;
	
	@FindBy(xpath="//*[@id=\"unit_table\"]/tbody/tr[1]/td[4]/button[2]") 
	public WebElement deleteNameButton;
	
	@FindBy(xpath="/html/body/div[4]/div/div[4]/div[2]/button") 
	public WebElement deleteName_ok;
	
	@FindBy(xpath="//*[@id=\"toast-container\"]/div")
	public WebElement deleteUnit_message;

	
	
	public void unitCredentials() throws InterruptedException
	{

	    waitHandler=new WaitUtility(driver);
		waitHandler.normalWait(4000);

		objActions.click(webUnit);
		objActions.click(webAdd);
		waitHandler=new WaitUtility(driver);
	    waitHandler.normalWait(4000);
		 
	}
	public void addCredentials(String name,String shortName) throws InterruptedException
	{
		objActions.sendkeys(webName, name);
		objActions.sendkeys(webshortName, shortName);
		objActions.DropdownselectByVisibleText(webAllowDecimal, "Yes");
		objActions.click(webSave);
	    waitHandler=new WaitUtility(driver);
		waitHandler.normalWait(4000);
	}
	public String getMessage()
	{
		waitHandler.presenceOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div"), 3);
		return objActions.getText(webMessage);
	
	}
	public void search(String name) throws InterruptedException
	{  
		waitHandler=new WaitUtility(driver);
	    waitHandler.normalWait(4000);
	    objActions.sendkeys(search,name);
		waitHandler=new WaitUtility(driver);
	    waitHandler.normalWait(4000);
	}

	public String getName() throws InterruptedException
	{
		
		return objActions.getText(searchName);
		
	}
	public void deteteName() throws InterruptedException
	{
		objActions.click(deleteNameButton);
		waitHandler=new WaitUtility(driver);
	    waitHandler.normalWait(4000);
		objActions.click(deleteName_ok);
		waitHandler=new WaitUtility(driver);
	    waitHandler.normalWait(4000);
		
	}
	public String delete_unitMessage()
	{
		return objActions.getText(deleteUnit_message);
	}
	

}
