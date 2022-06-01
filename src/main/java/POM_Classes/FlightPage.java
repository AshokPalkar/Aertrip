package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPage extends BaseClass {
	@FindBy(xpath = "//input[@id='js-origin-airport']")
	private WebElement origin;

	@FindBy(xpath = "//input[@id='js-dest-airport']")
	private WebElement destination;

	@FindBy(xpath = "(//ul[@id='ui-id-1']//li)[4]")
	private WebElement originList;

	@FindBy(xpath = "(//ul[@id='ui-id-2']//li)[9]")
	private WebElement destinationList;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchButton;

	@FindBy(xpath = "(//div[@class='flightFilter']//span)[1]")
	private WebElement result;

	public FlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void inputFlightPageOrigin() {
		origin.sendKeys("ben");
	}

	public void clickFlightPageOriginList() {
		originList.click();
	}

	public void inputFlightPageDestination() {
		destination.sendKeys("raj");
	}

	public void clickFlightPageDestinationList() {
		destinationList.click();
	}

	public void clickFlightPageSearchButton() {
		searchButton.click();
	}

	public String getTextOfResults() {

		String output = "";

		int i = 0;
		while (i < 100) {
			try {
				i++;
				WebElement result1 = driver.findElement(By.xpath("(//div[@class='flightFilter']//span)[1]"));
				output = result1.getText();

			} catch (StaleElementReferenceException e) {

			}

		}

		System.out.println(output);
		return output;
	}

}
