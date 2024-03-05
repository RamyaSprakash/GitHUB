package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import usablity.Use;


public class Login extends Use{
	WebDriver driver;

	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement email;
	@FindBy(id = "userPassword")
	WebElement password;
	@FindBy(id = "login")
	WebElement submit;
@FindBy(css="[class*=flyInOut]")
WebElement msg;
	public ProductBacklog signin(String UN, String pwd)  {
		email.sendKeys(UN);
		password.sendKeys(pwd);
		submit.click();
		
		ProductBacklog pb=new ProductBacklog(driver);
		return pb;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errormsg() throws InterruptedException
	{
		Thread.sleep(1000);
		return msg.getText();
	}
}
