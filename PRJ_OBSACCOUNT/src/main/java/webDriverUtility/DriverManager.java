package webDriverUtility;

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

}
