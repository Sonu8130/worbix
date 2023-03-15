package Contata.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Contata.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#user_name")
	WebElement Email;

	@FindBy(css = "#user_password")
	WebElement Password;

	@FindBy(css = "button[type='button']")
	WebElement Submit;

	@FindBy(css = ".relevate-text")
	WebElement RelevateText;

	public leftNavigation loginApplication(String email, String password) {
		Email.sendKeys(email);
		Password.sendKeys(password);
		Submit.click();
		leftNavigation leftnavigation = new leftNavigation(driver);
		return leftnavigation;

	}

	public void goTo() {
		driver.get("https://d194qgwgpyjo8e.cloudfront.net/auth#/login");

	}

}
