package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commoncomponents.GeneralElements;

public class Loginpage extends GeneralElements{

	private String product = "MacBook";
	WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//span[contains(text(),'My Account')]")
	WebElement myaccountlink;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginlink;
	
	@FindBy(id= "input-email")
	WebElement username;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginsubmit;
	
	//action methods
	public void launchURL(String url)
	{
		driver.get(url);
	}
	
	public void loginactions(String uname, String pword)
	{
		myaccountlink.click();
		loginlink.click();
		username.sendKeys(uname);
		password.sendKeys(pword);
		loginsubmit.click();
	}
	
	public void gotohome()
	{
		super.gotohome();
	}
	
	public String getProduct()
	{
		return this.product  =product;
	}
	
	public void setProduct(String p1)
	{
		this.product= product;
	}
	



}
