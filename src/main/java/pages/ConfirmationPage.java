package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import usablity.Use;

public class ConfirmationPage {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css=".hero-primary")
	WebElement msg;
	
	public String msgdisplay()
	{
	  return msg.getText();
	}
	
}
