package Contata.PageObjects;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Contata.AbstractComponents.AbstractComponents;

public class people extends AbstractComponents {
	WebDriver driver;
	String fName = "Sonu";
	String lName = "kumar";

	String rndmString = RandomStringUtils.randomAlphabetic(5);
	String cEmail = rndmString + "sonu@maildrop.cc";

	public people(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".body-slot-container")
	WebElement addPopupContainer;

	@FindBy(css = ".table__add__btn:first-of-type")
	WebElement add;

	@FindBy(css = ".modal-title")
	WebElement popupTitle;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement email;

	@FindBy(css = ".category__dropdown")
	WebElement categoryDropdown;

	@FindBy(xpath = "//span[@class='multiselect__option'] //span[text()='Leads']")
	WebElement category;

	@FindBy(css = ".modal-footer button:last-child")
	WebElement saveButton;

	@FindBy(xpath = "//ul[@class='multiselect__content']/li/span/span")
	List<WebElement> listItem;

	@FindBy(css = ".contact__name")
	WebElement ContactNameOnDashboard;

	@FindBy(css = "//span[@id='name0']")
	WebElement selectFirstContactByName;

	@FindBy(xpath = "(//span[@id='name0']/../..)/following-sibling::div[3]")
	WebElement deleteFirstRowContact;

	@FindBy(css = "div.toast-body")
	WebElement deleteCnfrmMsg;

	@FindBy(xpath = "//ul[@class='multiselect__content']/li[3]")
	WebElement deleteOption;

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	WebElement deleteConfirm;

	@FindBy(css = ".toast-header")
	WebElement deleteToast;

	@FindBy(css = ".multiselect__select")
	WebElement openBulkActionDropdown;

	@FindBy(css = "div[class='list__table__body__row']:nth-child(1) [class='checkmark']")
	List<WebElement> falseC;

	@FindBy(xpath = "//ul[@class='multiselect__content']/li[1]")
	WebElement addPropertyButton;

	@FindBy(css = ".modal-content")
	WebElement addPropertyPopup;

	@FindBy(xpath = "//div[@class='body-slot-container']//div[@class='multiselect__select']")
	WebElement SelectPropertyDropdown;

	@FindBy(xpath = "//input[@placeholder='Select Property']")
	WebElement enterPropertyName;

	public void createContact() throws InterruptedException {
		add.click();
		waitForElementToAppear(addPopupContainer, 5);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(cEmail);
		categoryDropdown.click();
		waitForElementToAppear(category, 2);
		category.click();
		saveButton.click();
		Assert.assertEquals(ContactNameOnDashboard.getText(), fName + " " + lName);
		implicitlyWait(5000);
		driver.navigate().back();
		implicitlyWait(5000);

	}

	public void deleteContact() {
		for (WebElement firstCheckbox : falseC) {
			firstCheckbox.click();
			break;
		}
		openBulkActionDropdown.click();
		deleteOption.click();
		implicitlyWait(2);
		deleteConfirm.click();
		waitForElementToAppear(deleteToast, 4);
		Assert.assertEquals(deleteCnfrmMsg.getText(), "Contacts deleted successfully.");
	}

	public void addContactToGroup() {
		addPropertyButton.click();
		SelectPropertyDropdown.click();
		 	
	}

}
