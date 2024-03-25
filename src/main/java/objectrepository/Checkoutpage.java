package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commoncomponents.GeneralElements;

public class Checkoutpage  extends GeneralElements{
	
WebDriver driver;
	
	public Checkoutpage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='new']")
	WebElement newaddressradiobutton;
	
	@FindBy(id="input-payment-firstname")
	WebElement firstname;
	
	@FindBy(id="input-payment-lastname")
	WebElement lastname;
	
	@FindBy(id="input-payment-address-1")
	WebElement addressline1;
	
	@FindBy(id="input-payment-city")
	WebElement city;
	
	@FindBy(id="input-payment-postcode")
	WebElement postcode;
	
	@FindBy(name = "country_id")
	WebElement dropdown1;
	
	@FindBy(name = "zone_id")
	WebElement dropdown2;
	
	@FindBy(id="button-payment-address")
	WebElement continuebutton2;
	
	@FindBy(name = "comment")
	WebElement commentbox;
	
	@FindBy(xpath="//input[@type='check']")
	WebElement privacycheckbox;
	
	//actions method
	public void checkpoutpageactions() throws InterruptedException
	{
		newaddressradiobutton.click();
		firstname.sendKeys("Raja");
		lastname.sendKeys("s");
		addressline1.sendKeys("1st main");
		city.sendKeys("whitefield");
		postcode.sendKeys("560066");
		Thread.sleep(3000);
		Select S = new Select(dropdown1);
		S.selectByVisibleText("India");
		Thread.sleep(3000);
		Select S1 = new Select(dropdown2);
		S1.selectByVisibleText("Karnataka");
		Thread.sleep(3000);
		continuebutton2.click();
		commentbox.sendKeys("Hi I am ordering a product");
		Thread.sleep(3000);
		privacycheckbox.click();
		Thread.sleep(2000);
	}
	
}
