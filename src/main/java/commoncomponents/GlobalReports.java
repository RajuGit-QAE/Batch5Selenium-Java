package commoncomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GlobalReports {
	
	public static ExtentReports generateReport()
	{
		
		String path = "C:\\Users\\ADMIN\\eclipse-workspace\\AutomationProject1\\AllReports";
		
		ExtentSparkReporter ESR = new ExtentSparkReporter(path);
		ESR.config().setDocumentTitle("RajaReportFile");
		ESR.config().setReportName("TestCaseResult");
		
		
		
		ExtentReports extent = new ExtentReports(); //this will help to create a report
		extent.attachReporter(ESR);
		extent.setSystemInfo("TesterName", "RajaTrainer");
		
		return extent;
	}

}
