package po;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class SearchProduct {
WebDriver driver;
	
	public SearchProduct(WebDriver driver) {
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		act.moveToElement(driver.findElement(women)).moveToElement(driver.findElement(tshirts)).click().build().perform();
	}
	public String firstProduct() {
		String fpName = driver.findElement(firstProd).getText();
		driver.findElement(searchBox).sendKeys(fpName);
		driver.findElement(searchBtn).click();
		return fpName;
	}
	public String searchedProduct() {
		String spName = driver.findElement(searchedProd).getText();
		return spName;		
	}


}
