package commontests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import commoncomponents.GlobalReports;

public class NewListenerTest extends BaseTest implements ITestListener{
	ExtentTest test;
	 ExtentReports extent = GlobalReports.generateReport();
	@Override
	public void onTestStart(ITestResult result) {
		test  = extent.createTest(result.getMethod().getMethodName());//fulltest
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance()); //testcase failiure infor
		} catch (Exception e) {
		
			e.printStackTrace();
		
		}	
    	
    	String screenpath = null;
		if(result.getStatus() == ITestResult.FAILURE )
    	{
    		try {
				screenpath  = screenshots(result.getMethod().getMethodName(), driver);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
    	}
    	
		test.log(Status.FAIL, "Test Failed");
    	test.addScreenCaptureFromPath(screenpath, result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	

}
