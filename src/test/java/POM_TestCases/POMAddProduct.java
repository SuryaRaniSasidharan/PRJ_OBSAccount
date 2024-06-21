package POM_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.PropertyFileRead;
import waitUtility.WaitUtility;
import webDriverUtility.WebDriverActions;

public class POMAddProduct {
	WebDriverActions objActions;
	WebDriver driver;
	WaitUtility waitHandler;
	
	public POMAddProduct(WebDriver driver)
	{
		this.driver=driver;
		objActions=new WebDriverActions(driver);
		PageFactory.initElements(driver, this); 
	}
	@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[2]/a")
	public WebElement web_addProduct;
	
	@FindBy(xpath="//*[@id=\"name\"]")
	public WebElement productName;
	
//	@FindBy(xpath="//*[@id=\"product_add_form\"]/div[1]/div/div/div[2]/div/div/span[2]/button")
//	public WebElement brand_addButton ;
//	
//	@FindBy(xpath="//*[@id=\"name\"]")
//	public WebElement brandName ;
//	
//	@FindBy(xpath="//*[@id=\"description\"]")
//	public WebElement brandshort_descrpt ;
//	
//	@FindBy(xpath="//*[@id=\"quick_add_brand_form\"]/div[3]/button[1]")
//	public WebElement brandSave;
	
	@FindBy(xpath="//*[@id=\"alert_quantity\"]")
	public WebElement alertQuanity;
	
	@FindBy(xpath="//*[@id=\"expiry_period\"]")
	public WebElement expires_in;
	
	@FindBy(xpath="//*[@id=\"single_dpp\"]")
	public WebElement expc_tax;
	
	@FindBy(xpath="//*[@id=\"product_add_form\"]/div[4]/div/div/div/button[4]")
	public WebElement save;
	
	@FindBy(xpath="//*[@id=\"toast-container\"]/div")
	public WebElement success_msg;
	
	public void click_addProdct() {
		objActions.click(web_addProduct);
	}
	
	
	public void product() throws InterruptedException
	{
		objActions.sendkeys(productName, PropertyFileRead.readConfigFile("productname"));
		waitHandler=new WaitUtility(driver);
		waitHandler.normalWait(8000);
		objActions.sendkeys(alertQuanity, PropertyFileRead.readConfigFile("alertquantity"));
		waitHandler=new WaitUtility(driver);
		waitHandler.normalWait(8000);
		objActions.sendkeys(expires_in, PropertyFileRead.readConfigFile("expiresin"));
		waitHandler=new WaitUtility(driver);
		waitHandler.normalWait(8000);
		objActions.sendkeys(expc_tax, PropertyFileRead.readConfigFile("expc"));
		waitHandler=new WaitUtility(driver);
		waitHandler.normalWait(8000);
		objActions.click(save);
	}
	public String getText()
	{
		waitHandler.presenceOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div"), 3);
		return objActions.getText(success_msg);
	}

	
	

	

}
