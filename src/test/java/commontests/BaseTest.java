package commontests;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

import objectrepository.Loginpage;

public class BaseTest {
	
	public static WebDriver driver;
	public Loginpage loginpage;
	
	public  WebDriver startDriver() throws IOException
	{
		
		FileInputStream FIS = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\AutomationProject1\\src\\main\\resources\\globaldata\\properties");
		Properties P = new Properties();
		P.load(FIS);
		String browser = P.getProperty("browser");

		
		if(browser.equals("chrome")) 
		{
		
			driver = new ChromeDriver();
			
		}
		
		else if (browser.equals("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		
		else if (browser.equals("edge")) 
		{
			
			driver = new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().deleteAllCookies();
		
		return driver;
		
	}	
	
	public static String screenshots(String testcasename, WebDriver driver) throws IOException
	{
		File F = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(F, new File("C:\\Users\\ADMIN\\eclipse-workspace\\AutomationProject1\\screenshots" + testcasename + ".png"));
	
		return "C:\\Users\\ADMIN\\eclipse-workspace\\AutomationProject1\\screenshots" + testcasename + ".png";
	
	}
		
	@BeforeMethod(alwaysRun = true)
	public Loginpage launchapplication() throws IOException	
	{
		driver = startDriver();
		loginpage =  new Loginpage(driver);
		
		return loginpage;
	}
	
	@AfterMethod(alwaysRun= true)
	public void endTest()
	{
		driver.close();
	}

	

}
