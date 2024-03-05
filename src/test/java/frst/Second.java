package frst;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import globaldetails.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.Login;
import pages.OrdersPage;
import pages.ProductBacklog;

public class Second extends BaseTest {
	List l = new LinkedList();

@Test(dataProvider="getData")
public void app(String email,String pwd, String l) throws IOException, InterruptedException
{
	//l.add("ZARA COAT 3");
	//l.add("ADIDAS ORIGINAL");
	//l.add("IPHONE 13 PRO");
		ProductBacklog pb=lp.signin(email,pwd);
		List<WebElement>products=pb.getproducts();
		pb.addtocart(l);
		CartPage cp=pb.GotoCart();
	    List<WebElement> cartProducts=	cp.validationofitems();
		for (int i = 0; i < cartProducts.size(); i++) {

			String n = cartProducts.get(i).getText();
			if (l.contains(n)) {
				Assert.assertTrue(true);
				System.out.println(n);
			}
		}
		CheckoutPage ck=cp.gotoCheckout();
		ConfirmationPage cf=ck.selectCountry("India");
		String confirmMessage = cf.msgdisplay();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}
@Test(dependsOnMethods= {"app"})
public void OrderHistoryTest()
{
	String name="ZARA COAT 3";
	ProductBacklog pb=lp.signin("anshika@gmail.com","Iamking@000");
OrdersPage op=pb.gotoOrderpage();
Assert.assertTrue(op.productdisplayvalidation(name), name+" is present in orderspage");
}

@DataProvider
public Object[][] getData()
{
  return new Object[][]  {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"}, {"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL" } };
  /*Object[][] obj= new Object[1][3];
  obj[0][0]="anshika@gmail.com";
  obj[0][1]="Iamking@000";
  obj[0][2]="ZARA COAT 3";
return obj;*/
}

}
