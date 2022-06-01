package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import POM_Classes.BaseClass;
import POM_Classes.FlightPage;
import POM_Classes.HomePage;
import POM_Classes.UtilityClass;

public class AerTrip_TestClass extends BaseClass {
	HomePage home;
	FlightPage flight;
	public static ExtentReports extentReport;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest test;

	@BeforeTest
	public void setUpExtentReport() {

		UtilityClass.extentReport();

	}

	@AfterTest
	public void endReport() {
		extentReport.flush();
	}

	@BeforeMethod
	public void openBrowser() throws IOException {
		initializeBrowser();

		home = new HomePage(driver);
		flight = new FlightPage(driver);
		extentReport = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("extentReport.html");

	}

	@Test(invocationCount = 3)
	public void searchResult() {
		
		extentReport.createTest("searchResult");

		home.clickHomePageflightButton();

		flight.inputFlightPageOrigin();

		UtilityClass.webDriverWait("(//ul[@id='ui-id-1']//li)[4]");
		flight.clickFlightPageOriginList();

		flight.inputFlightPageDestination();

		UtilityClass.webDriverWait("(//ul[@id='ui-id-2']//li)[9]");
		flight.clickFlightPageDestinationList();

		flight.clickFlightPageSearchButton();

		UtilityClass.webDriverWait("(//div[@class='flightFilter']//span)[1]");
		String actual  = flight.getTextOfResults();
		String expected = "2 of 11 flights";
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getName());// To add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getThrowable());// To add error or exception in report
			
			String screenshotPath = UtilityClass.captureScreenShot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);  // To attach screenshot in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "TEST CASE SKIP IS" + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "TEST CASE PASS IS" + result.getName());
		}
		driver.close();
	}

}
