package Contata.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Contata.AbstractComponents.AbstractComponents;

public class leftNavigation extends AbstractComponents {
	WebDriver driver;

	public leftNavigation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By targetElement1 = By.cssSelector(".space_avatar");

	@FindBy(linkText = "Contacts")
	WebElement targetElement;

	@FindBy(css = ".fa-users")
	WebElement contact;

	@FindBy(css = ".fa-list")
	WebElement list;
	

	public people goToContact() {
		waitForElementToAppear(targetElement1, 3);
		mouseHover(targetElement);
		contact.click();
		people people = new people(driver);
		return people;
	}

	public ListModule goToList() {
		waitForElementToAppear(targetElement1, 3);
		mouseHover(targetElement);
		list.click();
		ListModule listModule = new ListModule(driver);
		return listModule;
	}

}
