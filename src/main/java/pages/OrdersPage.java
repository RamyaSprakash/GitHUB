package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import usablity.Use;

public class OrdersPage extends Use {
	WebDriver driver;
	public  OrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//tr) //td[2]")
	List<WebElement> productNames;
	
	public boolean productdisplayvalidation(String l)
	{
		boolean match =productNames.stream().anyMatch(product-> product.getText().equalsIgnoreCase(l));
		return match;
		
	}

}
