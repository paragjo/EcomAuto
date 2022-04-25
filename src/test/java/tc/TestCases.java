package tc;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import po.*;
import utils.BrowserFunctions;
@Test
public class TestCases {
	WebDriver driver;
	String browser = "chrome";
	String url = "http://automationpractice.com/index.php";

	@BeforeTest
	public void start() {
		driver = BrowserFunctions.getDriver(browser, url);

	}

	@Test(enabled = false)
	public void tc01_signup() {
		VerifySignUp user1 = new VerifySignUp(driver);
		user1.createAccount("lmno@opq.com", "Yeda", "Anna", "lmno@lmno", "145 Y Street", "NY", "18540", "2121212121");
	}
	
	@Test(enabled = true)
	public void tc04_errorMessages() {
		VerifySignUp user1 = new VerifySignUp(driver);
		user1.createAccount("qwe@opq.com", "", "", "", "145 Y Street", "NY", "18540", "2121212121");
	}
	
	@Test(enabled = true)
	public void tc02_signIn() {
		VerifyValidSignIn user = new VerifyValidSignIn(driver);
		user.login("lmno@opq.com", "lmno@lmno");
	}

	@Test(enabled = true)
	public void tc03_login() {
		VerifyInvalidSignIn user = new VerifyInvalidSignIn(driver);
		user.login("lmno@opq.com", "");
	}
	
	@Test(enabled = true)
	public void tc05_searchProduct() {
		VerifySearchProduct prod = new VerifySearchProduct(driver);
		prod.searchVerify();
		
	}
	
	@Test(enabled=true)
	public void tc06_buyProduct() {
		VerifyBuyProduct vbp = new VerifyBuyProduct(driver);
		vbp.buyProduct("lmno@opq.com", "lmno@lmno");
	}

	@AfterTest
	public void end() {
		BrowserFunctions.closeBrowser(driver);
	}
}
