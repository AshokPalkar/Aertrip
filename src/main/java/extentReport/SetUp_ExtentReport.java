package extentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SetUp_ExtentReport
{
	public static void main(String[] args) throws IOException 
	{
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");
		
		extentReports.attachReporter(sparkReporter);
		ExtentTest test1 = extentReports.createTest("Test-1");
		test1.pass("Test 1 is pass");
		
		ExtentTest test2 = extentReports.createTest("Test-2");
		test2.log(Status.FAIL,"Test 2 is Fail");
		
		ExtentTest test3 = extentReports.createTest("Test-3").skip("Test 3 is skip");
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("ExtentReport.html").toURI());  //  directly open the report
	}

}
