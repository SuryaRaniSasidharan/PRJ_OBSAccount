package POM_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import waitUtility.WaitUtility;
import webDriverUtility.WebDriverActions;

public class POMBrands {
	WebDriverActions objActions;
	WebDriver driver;
	WaitUtility waitHandler;
	
	public POMBrands(WebDriver driver)
	{
		this.driver=driver;
		objActions=new WebDriverActions(driver);
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath="//li[@id='tour_step5']//a")
	public WebElement webProduct;
	
	@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[10]/a")
	public WebElement webBrands;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button")
	public WebElement brandsAdd;
	
	@FindBy(xpath="//*[@id=\"name\"]")
	public WebElement BrandName;
	
	@FindBy(xpath="//*[@id=\"description\"]")
	public WebElement BrandShortName;
	
	@FindBy(xpath="//*[@id=\"brand_add_form\"]/div[3]/button[1]")
	public WebElement BrandSave;
	
	@FindBy(xpath="//*[@id=\"toast-container\"]/div")
    public WebElement BrandMessage;
	
	@FindBy(xpath="//*[@id=\"brands_table_filter\"]/label/input")
	public WebElement searchBrand;
	
	@FindBy(xpath="//*[@id=\"brands_table\"]/tbody/tr[10]/td[1]")
	public WebElement searchBrandName;
	
	public void clickBrand() throws InterruptedException
	{

		waitHandler=new WaitUtility(driver);
		  waitHandler.normalWait(4000);
		  objActions.click(webBrands);
		  objActions.click(brandsAdd);
		waitHandler=new WaitUtility(driver);
		  waitHandler.normalWait(4000);
	}
		
	public void addBrandsCredentials(String brand_name,String brandShort_name) throws InterruptedException
	{
		objActions.sendkeys(BrandName, brand_name);
		objActions.sendkeys(BrandShortName, brandShort_name );
		objActions.click(BrandSave);
		 waitHandler=new WaitUtility(driver);
		 waitHandler.normalWait(4000);
		
	}
	public String get_brandMessage()
	{
		waitHandler.presenceOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div"), 3);
		return objActions.getText(BrandMessage);
	
	}
	public void searchBrand(String name) throws InterruptedException
	{  
		waitHandler=new WaitUtility(driver);
	    waitHandler.normalWait(4000);
	    objActions.sendkeys(searchBrand,name);
		waitHandler=new WaitUtility(driver);
	    waitHandler.normalWait(4000);
	}

	public String getBrandName() throws InterruptedException
	{
		waitHandler=new WaitUtility(driver);
		 waitHandler.normalWait(4000);
		return objActions.getText(searchBrandName);
	}

}
