package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class VerifyBuyProduct {
WebDriver driver;
	
	public VerifyBuyProduct(WebDriver driver) {
		this.driver = driver;
	}
	
	By emailId = By.id("email");
	By password = By.id("passwd");
	By loginBtn = By.id("SubmitLogin");
	By logoutBtn = By.className("logout");
	By women = By.linkText("WOMEN");
	By printedDress = By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img");
	By more = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[2]/a[2]/span");
	By quant = By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]");
	By drpdown = By.xpath("//*[@id=\"group_1\"]");
	By colors = By.id("color_13");
	By addToCart = By.name("Submit");
	By proceedTochkout = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
	By chkout2 = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"); 
	By chkOut3 = By.name("processAddress");
	By chkbox = By.id("cgv");
	By chkOut4 = By.name("processCarrier");
	By pay  = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
	By orderConfirmBtn = By.xpath("//*[@id=\"cart_navigation\"]/button");
	By lastStep = By.xpath("//*[@id=\"center_column\"]/div/p");
	String expected = "Your order on My Store is complete.";
	
	public void buyProduct(String email, String pwd) {
		driver.findElement(By.className("login")).click();

		driver.findElement(emailId).sendKeys(email);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		System.out.println("Logged In");
		driver.findElement(women).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(printedDress)).moveToElement(driver.findElement(more)).click().build().perform();
		driver.findElement(quant).click();
		Select sel = new Select(driver.findElement(drpdown));
		sel.selectByVisibleText("L");
		driver.findElement(colors).click();
		driver.findElement(addToCart).click();
		driver.findElement(proceedTochkout).click();
		driver.findElement(chkout2).click();
		driver.findElement(chkOut3).click();
		driver.findElement(chkbox).click();
		driver.findElement(chkOut4).click();
		driver.findElement(pay).click();
		driver.findElement(orderConfirmBtn).click();
		String actual = driver.findElement(lastStep).getText();
		Assert.assertEquals(actual, expected, "Order not completed. Reason:"+actual);
		Reporter.log("Buy Product Test passed", true);
		driver.findElement(logoutBtn).click();
		
	}

}
