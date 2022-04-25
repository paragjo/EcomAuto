package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class VerifySignUp {
	WebDriver driver;
	
	public VerifySignUp(WebDriver driver) {
		this.driver = driver;
	}
	By signin = By.className("login");
	By createAcc = By.id("email_create");
	By createAccBtn = By.name("SubmitCreate");
	By gender = By.id("id_gender1");
	By fname = By.id("customer_firstname");
	By lname = By.id("customer_lastname");
	By password = By.id("passwd");
	By address = By.xpath("//*[@id=\"address1\"]");
	By city = By.id("city");
	By state = By.id("id_state");	
	By pincode = By.id("postcode");
	By mobile = By.id("phone_mobile");
	By submitBtn = By.id("submitAccount");
	
	public void createAccount(String email, String fn, String ln, String pwd, String adr, String ct, String code, String mob) {
		driver.findElement(signin).click();
		driver.findElement(createAcc).sendKeys(email);
		driver.findElement(createAccBtn).click();
		
		//Filling up info
		
		driver.findElement(gender).click();
		driver.findElement(fname).sendKeys(fn);
		driver.findElement(lname).sendKeys(ln);
		driver.findElement(password).sendKeys(pwd);
		//driver.findElement(By.id("firstname")).sendKeys(fn);
		//driver.findElement(By.id("lastname")).sendKeys(ln);
		driver.findElement(address).sendKeys(adr);
		driver.findElement(city).sendKeys(ct);
		
		Select sel = new Select(driver.findElement(state));
		sel.selectByVisibleText("New York");
		driver.findElement(pincode).sendKeys(code);
		driver.findElement(mobile).sendKeys(mob);
		driver.findElement(submitBtn).click();
		
		String actual = driver.getTitle();
		String expected = "My account - My Store";
		if(actual.equalsIgnoreCase(expected)) {
		Assert.assertTrue(true);
		String user = driver.findElement(By.className("account")).getText();
		Reporter.log("User Account Created for " + user, true);
		}
		else {
			String error= driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText();		
			Assert.assertTrue(true,error);
		}
		
		
	}

}
