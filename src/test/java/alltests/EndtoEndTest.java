package alltests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import commontests.BaseTest;
import objectrepository.AddtoCart;
import objectrepository.Checkoutpage;
import objectrepository.Loginpage;

public class EndtoEndTest extends BaseTest {
	
	
	@Test
	public void fullTest() throws InterruptedException, IOException
	{
	
		// login page
		
		Loginpage loginpage = launchapplication();
		
		loginpage.launchURL("https://naveenautomationlabs.com/opencart/");
		loginpage.loginactions("leoganapathy5699@gmail.com", "Opencart@000");
		loginpage.gotohome();
		
		
		//adding cart page
		//String product = "MacBook";
		
		loginpage.setProduct("Macbook");
		
		String  expectedmessage = "Success:";
		boolean expectedresult = true;
		AddtoCart addtocart = new AddtoCart(driver);
		addtocart.productselectionmethod(loginpage.getProduct());
		String actualmessage = addtocart.successmessage();
                                                                            
		Assert.assertTrue(actualmessage.contains(expectedmessage));
		addtocart.cartpage();
		Assert.assertEquals(addtocart.totalcomparison(), expectedresult);
		addtocart.proceedtocheckout();

		// checkout page
		Checkoutpage checkoutpage = new Checkoutpage(driver);
		checkoutpage.checkpoutpageactions();

	
	}
	
	@Test
	public void secondTest()
	{
		loginpage.launchURL("https://www.myntra.com/");
		
	}
	
	@Test
	public void thirdTest()
	{
		loginpage.launchURL("https://www.naukri.com/");
		
	}
	
	

}
