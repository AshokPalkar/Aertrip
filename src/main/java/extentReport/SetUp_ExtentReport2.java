package extentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SetUp_ExtentReport2 
{
	public static void main(String[] args) throws IOException 
	{
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");
		
//		sparkReporter.config().setTheme(Theme.DARK);
//		sparkReporter.config().setDocumentTitle("Automation Report");
//		sparkReporter.config().setReportName("Automation Extent Report");
//		sparkReporter.config().setTimeStampFormat("dd-MM-yyyy hh-mm-ss");
		
		sparkReporter.loadJSONConfig(new File("C:\\Users\\DELL\\eclipse-workspace\\Aertrip\\ExtentReportConfig.json"));
		
		
		extentReports.attachReporter(sparkReporter);
		extentReports.createTest("Test-1")
		.assignAuthor("Ashok Palkar")
		.assignCategory("Functional")
		.assignDevice("Chrome 101")
		.log(Status.INFO, "Info1")
		.log(Status.INFO, "Info2")
		.log(Status.PASS, "pass1")
		.log(Status.PASS, "pass2")
		.log(Status.SKIP, "skip")
		.log(Status.WARNING, "warning1")
		.log(Status.WARNING, "warning2");
		
		
		
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("ExtentReport.html").toURI());  //  directly open the report
	}

}
