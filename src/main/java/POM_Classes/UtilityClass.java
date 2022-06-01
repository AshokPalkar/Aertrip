package POM_Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class UtilityClass extends BaseClass {
	
	public static ExtentReports extentReport;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest test;
	
	public static String getPropertyFileData(String key) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Aertrip\\Aertrip.properties");

		Properties prop = new Properties();
		prop.load(fis);

		String keyValue = prop.getProperty(key);
		return keyValue;
	}

	public static void webDriverWait(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public static void extentReport() {
		extentReport = new ExtentReports();
		extentReport.setSystemInfo("Hostname", "LocalHost");
		extentReport.setSystemInfo("OS", "Windows 10");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("Tester Name", "Ashok Palkar");
		
		
		sparkReporter = new ExtentSparkReporter("C:\\Users\\DELL\\eclipse-workspace\\Aertrip\\target\\ExtentReport.html");
		sparkReporter.config().setDocumentTitle("AerTrip Automation Report");
		sparkReporter.config().setReportName("Functional Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extentReport.attachReporter(sparkReporter);
	}
	
	public static String captureScreenShot(WebDriver driver,String screenShotName) throws IOException {
		
		String date = new SimpleDateFormat("yyyyMMddmmss").format(new Date());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = ("C:\\Users\\DELL\\eclipse-workspace\\Aertrip\\ScreenShot"+ screenShotName + date+".png");
		File finalDestination  = new File(destination); 
		FileUtils.copyFile(src, finalDestination);
		
		return destination;
	}
	

}
