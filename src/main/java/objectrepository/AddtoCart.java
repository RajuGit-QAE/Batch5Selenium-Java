package objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commoncomponents.GeneralElements;

public class AddtoCart extends GeneralElements{
	
WebDriver driver;
	
	public AddtoCart(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@title='naveenopencart']")
	WebElement homepagelink;
	
	@FindBy(xpath= "//div[@class='product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12']/div/div/h4/a")
	List<WebElement> products;//iphone, apple, macbook, canon
	
	@FindBy(xpath="//div[@class='product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12']/div/div/button/span")
	List<WebElement> addtocartsbuttons;
	
	@FindBy(className="alert-success")
	WebElement successmessage;
	
	@FindBy(xpath="//div[@id='cart']")
	WebElement carticon;
	
	@FindBy(xpath="//table[@class='table table-bordered']/tbody/tr/td[2]")
	List<WebElement> prices;
	
	//int l = prices.size();//5
	
	@FindBy(xpath="//table[@class='table table-bordered']/tbody/tr[2]/td[2]")
	WebElement totalamount;
	
	@FindBy(xpath="//a[@href = 'https://naveenautomationlabs.com/opencart/index.php?route=checkout/cart']")
	WebElement proceedtocheckoutlink;
	
	@FindBy(xpath="//div[@class='pull-right']")
	WebElement firstcontinuebutton;
	
	//actions methods
	
	public void productselectionmethod(String desiredproduct) throws InterruptedException//iphone
	{
		int len = products.size();//4
		for(int i = 0; i<len; i++)// 0 = iphone
		{
			if(products.get(i).getText().equals(desiredproduct)) // "iphone" = desiredproduct
			{
				addtocartsbuttons.get(i).click();
				addtocartsbuttons.get(i).click();
				addtocartsbuttons.get(i).click();
				Thread.sleep(5000);
			}
		}
		
	}
	
	public void cartpage()
	{
		carticon.click();
		
	}
	
	public boolean totalcomparison()
	{
		
		boolean finalresult = true;
		 int len1 = prices.size();
		 System.out.println(len1);
		 String totalwebelement = totalamount.getText();
		 String  newtotalwebelement = totalwebelement.replace("$", "").replace(",", "");
		 
		 double total = Double.parseDouble(newtotalwebelement);
		 System.out.println(total);
		 
		 
		 double sum = 0; //2408
		 for (int i = 0; i<len1-1; i++)
		 {
			  String x1 = prices.get(i).getText();//$4,00
			  
			  String x2 = x1.replace("$", "").replace(",", "");
			  
			  double productamount = Double.parseDouble(x2);
			  sum = sum + productamount;
			  
		 }
		 System.out.println(sum);
		 if (sum == total)
		 {
			 boolean result = true;
		 }
		 
		 return finalresult;
	}
	
	public void proceedtocheckout()
	{
		proceedtocheckoutlink.click();
		firstcontinuebutton.click();
	}
	
	
	public String successmessage()
	{
		String actualmessage = successmessage.getText();
	
		return actualmessage;
	}
	
	public void callhomepage()
	{
		super.gotohome();
	}

	
	
}
