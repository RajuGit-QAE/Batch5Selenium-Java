package commoncomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GeneralElements {
	
WebDriver driver;
	
	public GeneralElements(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='naveenopencart']")
	WebElement homelink;
	
	
	
	//action method
	public void gotohome()
	{
		homelink.click();
	}
	
	

}
