package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class BrowserFunctions {
	@SuppressWarnings("deprecation")
	public static WebDriver getDriver(String type, String url)
	{
		
		WebDriver driver=null;
		if(type.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(type.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		else
			Assert.assertTrue(false,"No Browser type was sent");
		
		driver.manage().deleteAllCookies();
		driver.get(url);
		Reporter.log("Navigated to browser:"+type+"\nURL: "+url, true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}

}
