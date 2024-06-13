package POM_TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import waitUtility.WaitUtility;
import webDriverUtility.WebDriverActions;

public class POMLogin {
	
	WebDriverActions objHandler;
	WebDriver driver;
	WaitUtility utilityHandler;
	
	public POMLogin(WebDriver driver)
	{
		this.driver=driver;
		objHandler=new WebDriverActions(driver);
		PageFactory.initElements(driver, this); // used to initialise the elements
	}
	
	@FindBy(xpath="//*[@id=\"username\"]")
	public WebElement webUsername;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	public WebElement webPassword;
	
	@FindBy(xpath="//label[text()[normalize-space()='Remember Me']]")
	public WebElement webRememberMe;
	

    @FindBy(name="remember") 
    public WebElement rememberMeClick;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/form/div[4]/div/button")
	public WebElement webLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/form/div[4]/div/a")
	public WebElement webForgotpassword;
	
	
	public void loginCredentials(String userName,String password) throws InterruptedException
	{   
		objHandler.sendkeys(webUsername, userName);
		utilityHandler=new WaitUtility(driver);
		utilityHandler.normalWait(2000);
		
		objHandler.sendkeys(webPassword, password);
		utilityHandler=new WaitUtility(driver);
		utilityHandler.normalWait(2000);
		
	}
	

	 public void loginButton() throws InterruptedException {
		objHandler.click(webLogin);
		utilityHandler=new WaitUtility(driver);
		utilityHandler.normalWait(2000);
	 }	


		
	}
	
	
	
	
			


