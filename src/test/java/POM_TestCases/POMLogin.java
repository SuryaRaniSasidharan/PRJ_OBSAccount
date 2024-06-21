package POM_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import waitUtility.WaitUtility;
import webDriverUtility.WebDriverActions;

public class POMLogin {
	
	WebDriverActions objActions;
	WebDriver driver;
	WaitUtility waitHandler;
	
	public POMLogin(WebDriver driver)
	{
		this.driver=driver;
		objActions=new WebDriverActions(driver);
		PageFactory.initElements(driver, this); // used to initialise the elements
	}
	
	@FindBy(xpath="//*[@id=\"username\"]")
	public WebElement webUsername;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	public WebElement webPassword;
	
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/form/div[4]/div/button")
	public WebElement webLogin;
	
	@FindBy(xpath="//*[@id=\"step-0\"]/div[3]/button[3]")
	public WebElement webEndTour;
	
	@FindBy(xpath="//li[@id='tour_step5']//a")
	public WebElement webProduct;
	
	@FindBy(xpath="/html/body/div[2]/header/nav/div/ul/li[2]/a/span")
	public WebElement profile;
	
	@FindBy(xpath="/html/body/div[2]/header/nav/div/ul/li[2]/ul/li[2]/div[2]/a")
	public WebElement signout;
	
	
	
	public void loginCredentials(String userName,String password) throws InterruptedException
	{   
		objActions.sendkeys(webUsername, userName);
		waitHandler=new WaitUtility(driver);
		waitHandler.normalWait(2000);
		
		objActions.sendkeys(webPassword, password);
		waitHandler=new WaitUtility(driver);
		waitHandler.normalWait(2000);
		
		objActions.click(webLogin);
		try {
			if(webEndTour.isDisplayed())
			{
				objActions.click(webEndTour);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception Handled");
		}
	}
	public void productClick() throws InterruptedException
	{
		waitHandler=new WaitUtility(driver);
		waitHandler.normalWait(4000);
		objActions.click(webProduct);
		waitHandler=new WaitUtility(driver);
		waitHandler.normalWait(4000);
	}
	public void signout() throws InterruptedException {
		
		objActions.click(profile);
		waitHandler=new WaitUtility(driver);
		waitHandler.normalWait(4000);
		objActions.javascriptClick(signout);
		waitHandler.normalWait(8000);
		
		
	}



		
	}
	
	
	
	
			


