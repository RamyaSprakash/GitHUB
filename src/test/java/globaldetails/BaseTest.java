package globaldetails;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.Login;

public class BaseTest {
public WebDriver driver;
public Login lp;

public WebDriver invokeBrowser() throws IOException
{
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globaldata\\data.properties");
	prop.load(fis);
	String BrowserName=prop.getProperty("browser");
	
	if(BrowserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
	
	}
	else if(BrowserName.equalsIgnoreCase("firefox"))
	{
		
	}
	else if(BrowserName.equalsIgnoreCase("edge"))
	{
		
	}
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
}
@BeforeMethod(alwaysRun=true)
public Login launchApplication() throws IOException
{
	driver=invokeBrowser();
	 lp=new Login(driver);
	lp.goTo();
	return lp;
}
@AfterMethod(alwaysRun=true)
public void closebrowser()
{
	driver.close();
}
}
