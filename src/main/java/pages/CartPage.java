package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import usablity.Use;

public class CartPage extends Use {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement checkout;
	public List<WebElement> validationofitems()
	{
	return cartProducts;
}
	public CheckoutPage gotoCheckout() throws InterruptedException
	{
	scrolling();
	disappear();
	checkout.click();
	return new CheckoutPage(driver);
	}
}
