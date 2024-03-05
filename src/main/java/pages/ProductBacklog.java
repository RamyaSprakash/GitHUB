package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import usablity.Use;

public class ProductBacklog extends Use{
	WebDriver driver;
	public ProductBacklog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	By productBy =By.xpath("//div[contains(@class,'mb-3')]");
	@FindBy(css="div.card-body")
	List<WebElement> products;
	@FindBy(css=".card-body button:last-of-type")
	List<WebElement> add;
	By appear=By.cssSelector("#toast-container");
	@FindBy(css=".ng-animating")
	WebElement Dissapper;
	@FindBy(css="button[routerlink*='cart']")
	WebElement cart;
	public List<WebElement> getproducts()
	{
		visible(productBy);
		return products;
	}
	public void addtocart(String l) throws InterruptedException
	{
		for (int i = 0; i < products.size(); i++) {
			WebElement prod = products.get(i).findElement(By.cssSelector("b"));
			String n = prod.getText();
			if (l.contains(n)) {
				add.get(i).click();
				visible(appear);
				disappear();
				//Thread.sleep(1000);
			}
	}
		

	}
	
	public CartPage GotoCart()
	{
		cart.click();
		//driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		return new CartPage(driver);
	}
}
