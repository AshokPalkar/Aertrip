package POM_Classes;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;

	public void initializeBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\eclipse-workspace\\Aertrip\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(UtilityClass.getPropertyFileData("URL"));
	}

}
