package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {
WebDriver driver;
	
	public SignIn(WebDriver driver) {
		this.driver = driver;
	}
	By emailId = By.id("email");
	By password = By.id("passwd");
	By loginBtn = By.id("SubmitLogin");
	//By logoutBtn = By.className("logout");

	public void login(String email, String pwd) {
		driver.findElement(By.className("login")).click();

		driver.findElement(emailId).sendKeys(email);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
					
		
		//driver.findElement(logoutBtn).click();
		}
	}


