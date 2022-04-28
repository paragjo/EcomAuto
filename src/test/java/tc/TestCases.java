package tc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import po.*;
import utils.BrowserFunctions;
import utils.PropertyHelper;
@Test
public class TestCases {
	WebDriver driver;
	PropertyHelper prObj = new PropertyHelper("obj_repo.properties");
	String url = prObj.getValueofKey("baseUrl");			
	String browser = prObj.getValueofKey("browser");
	//String browser = "chrome";
	//String url = "http://automationpractice.com/index.php";

	@BeforeTest
	public void start() {
		driver = BrowserFunctions.getDriver(browser, url);

	}

	@Test(enabled = false)
	public void tc01_signup() {
		SignUp user1 = new SignUp(driver);
		user1.createAccount("lmno@opq.com", "Yeda", "Anna", "lmno@lmno", "145 Y Street", "NY", "18540", "2121212121");
		String actual = driver.getTitle();
		String expected = "My account - My Store";
		Assert.assertEquals(actual, expected,"User was not registered");
		String user = driver.findElement(By.className("account")).getText();
		Reporter.log("User Account Created for " + user, true);
	}
	
	@Test(enabled = true)
	public void tc04_errorMessages() {
		SignUp user1 = new SignUp(driver);
		user1.createAccount("qwe@opq.com", "", "", "", "145 Y Street", "NY", "18540", "2121212121");
		String actual = driver.getTitle();
		String expected = "My account - My Store";
		Assert.assertFalse(actual.equalsIgnoreCase(expected), "No Errors");
		String error= driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText();
		Reporter.log("Error message displayed: " + error, true);
	}
	
	@Test(enabled = true)
	public void tc02_verifySignIn() {
		SignIn user = new SignIn(driver);
		user.login("lmno@opq.com", "lmno@lmno");
		String actual = driver.getTitle();
		String expected = "My account - My Store";
		Assert.assertEquals(actual, expected,"User could not be logged in");
		String userlogged = driver.findElement(By.className("account")).getText();
		Reporter.log("User " + userlogged + " logged in Successfully", true);	
	}

	@Test(enabled = true)
	public void tc03_VerifyInvalidSignIn() {
		SignIn user = new SignIn(driver);
		user.login("lmno@opq.com", "");
		String mp = "Password is required.";
		String ip = "Authentication failed.";
		
		String msg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();

		if(msg.equalsIgnoreCase(mp))
		{
			Assert.assertTrue(true, msg);
			Reporter.log("Couldn't login. Reason: "+mp, true);
		}
		else if(msg.equalsIgnoreCase(ip))
		{
			Assert.assertTrue(true, msg);
			Reporter.log("Couldn't login. Reason: "+ip, true);
		}
	}
	
	@Test(enabled = true)
	public void tc05_searchProduct() {
		SearchProduct prod = new SearchProduct(driver);
		prod.searchVerify();
		String fp = prod.firstProduct();
		String sp = prod.searchedProduct();
		Assert.assertEquals(fp, sp, "Same product not found");
		Reporter.log("Validated the searched and first product", true);
		
	}
	
	@Test(enabled = true)
	public void tc06_buyProduct() {
		driver.manage().deleteAllCookies();
		BuyProduct vbp = new BuyProduct(driver);
		SignIn user = new SignIn(driver);
		user.login("lmno@opq.com", "lmno@lmno");
		String actual = vbp.buyProduct();
		String expected = "Your order on My Store is complete.";
		Assert.assertEquals(actual, expected, "Order not completed. Reason:"+actual);
		Reporter.log("Buy Product Test passed", true);
	}

	@AfterTest
	public void end() {
		BrowserFunctions.closeBrowser(driver);
	}
}
