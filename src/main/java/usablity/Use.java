package usablity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.OrdersPage;

public class Use {
	WebDriver driver;

	public Use(WebDriver driver)
	{
		
		this.driver=driver;
	}
	public void visible(By findBy)
	{
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void disappear() throws InterruptedException
	{
		Thread.sleep(2000);
	}	
	public void scrolling()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement ordersHeader;
	public OrdersPage gotoOrderpage()
	{
		ordersHeader.click();
		return new OrdersPage(driver);
	}
	
/*@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
WebElement submit;

	public void cart()
	{
		submit.click();
	}
	*/
}
