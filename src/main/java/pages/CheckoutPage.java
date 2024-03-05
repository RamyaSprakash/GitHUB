package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import usablity.Use;

public class CheckoutPage extends Use{
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//div[@class='form-group']/input")
	WebElement country;
	By listocCountries=By.cssSelector("section[class*='ta-results list-group ng']");
	@FindBy (css="section[class*='ta-results list-group ng'] button:nth-child(3)")
	WebElement selectoption;
	@FindBy(css="div[class='actions'] a")
	WebElement placeorder;
	public ConfirmationPage selectCountry(String c) throws InterruptedException
	{
		country.sendKeys(c);
		visible(listocCountries);
		selectoption.click();
		scrolling();
		placeorder.click();
		disappear();
		return new ConfirmationPage(driver);

	}
	
}
