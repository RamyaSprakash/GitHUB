package frst;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import globaldetails.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.ProductBacklog;

public class ErrorValidation extends BaseTest{
@Test(groups= {"ErrorHandling"})
public void LoginValidation() throws InterruptedException {
	
	lp.signin("anshika@gmail.com","Iamki@000");
	String msg=lp.errormsg();
	Assert.assertEquals(msg, "Incorrect email or password.");
}

@Test
public void ProductCartvalidation() throws IOException, InterruptedException
{
		//List l = new LinkedList();
		String l="ZARA COAT 3";
		//l.add("ADIDAS ORIGINAL");
		//l.add("IPHONE 13 PRO");
		ProductBacklog pb=lp.signin("anshika@gmail.com","Iamking@000");
		List<WebElement>products=pb.getproducts();
		pb.addtocart(l);
		CartPage cp=pb.GotoCart();
	    List<WebElement> cartProducts=	cp.validationofitems();
		for (int i = 0; i < cartProducts.size(); i++) {

			String n = cartProducts.get(i).getText();
			if ("ZARA COAT 33".equals(n)) {
				Assert.assertFalse(false);
				System.out.println(n);
			}
		}
	
		

	}
}
