package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//li[@id='flights-module']")
	private WebElement flightButton;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickHomePageflightButton() {
		flightButton.click();
	}

}
