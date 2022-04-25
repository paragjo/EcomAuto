package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class VerifyValidSignIn {
WebDriver driver;
	
	public VerifyValidSignIn(WebDriver driver) {
		this.driver = driver;
	}
	By emailId = By.id("email");
	By password = By.id("passwd");
	By loginBtn = By.id("SubmitLogin");
	By logoutBtn = By.className("logout");

	public void login(String email, String pwd) {
		driver.findElement(By.className("login")).click();

		driver.findElement(emailId).sendKeys(email);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
					
		String actual = driver.getTitle();
		String expected = "My account - My Store";
		Assert.assertEquals(actual, expected,"User could not be logged in");
		String user = driver.findElement(By.className("account")).getText();
		Reporter.log("User " + user + " logged in Successfully", true);	
		driver.findElement(logoutBtn).click();
		}
	}


