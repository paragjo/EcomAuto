package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class VerifyInvalidSignIn {
WebDriver driver;
	
	public VerifyInvalidSignIn(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String email, String pwd) {
		driver.findElement(By.className("login")).click();

		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys(pwd);
		driver.findElement(By.id("SubmitLogin")).click();
		
		
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
}



