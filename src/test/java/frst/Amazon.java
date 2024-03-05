package frst;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		String s="OnePlus 12 (Silky Black, 12 GB RAM, 256GB)";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(s);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(5000);
	List<WebElement>items=driver.findElements(By.xpath("( //div[@data-cy='title-recipe'] ) //a[@target='_blank']"));
	//WebElement phone=items.stream().filter(i-> 
//	i.findElement(By.cssSelector("span")).getText().equals(s)).findFirst().orElse(null));
	WebElement prod =	items.stream().filter(product->
	product.findElement(By.cssSelector("span")).getText().equals(s)).findFirst().orElse(null);
	prod.click();
	Thread.sleep(5000);
	driver.findElement(By.id("add-to-cart-button")).click();
	/*for(int i=0;i<items.size();i++)
	{
		WebElement phone=items.get(i).findElement(By.cssSelector("span"));
		String name=phone.getText();
		if(name.equalsIgnoreCase(s))
		{
			items.get(i).click();
		}
	}
	}*/
	//div[@class='puisg-row'])
}
}
