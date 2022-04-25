package po;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

public class VerifySearchProduct {
WebDriver driver;
	
	public VerifySearchProduct(WebDriver driver) {
		this.driver = driver;
	}
	By women = By.linkText("WOMEN");
	By tshirts = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a");
	By firstProd = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a");
	By searchBox = By.id("search_query_top");
	By searchBtn = By.name("submit_search");
	By searchedProd = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a");
	
	public void searchVerify() {
		Actions act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		act.moveToElement(driver.findElement(women)).moveToElement(driver.findElement(tshirts)).click().build().perform();
		
		String fpName = driver.findElement(firstProd).getText();
		driver.findElement(searchBox).sendKeys(fpName);
		driver.findElement(searchBtn).click();
		
		String spName = driver.findElement(searchedProd).getText();
		Assert.assertEquals(fpName, spName, "Same product not found");
		Reporter.log("Validated the searched and first product", true);
		
	}


}
