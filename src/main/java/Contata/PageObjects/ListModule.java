package Contata.PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Contata.AbstractComponents.AbstractComponents;

public class ListModule extends AbstractComponents {
	WebDriver driver;

	public ListModule(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String rndmString = RandomStringUtils.randomNumeric(5);
	public String listName = "Group_" + rndmString;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement addListBtn;

	@FindBy(xpath = "//li[@role='presentation'][1] //a[@role='menuitem']/span")
	WebElement chooseStaticList;

	@FindBy(css = ".form-control")
	WebElement enterListName;

	@FindBy(css = ".modal-footer button:last-child")
	WebElement saveBtn;

	@FindBy(css = ".contact__name")
	WebElement listDetailsTitle;

	@FindBy(xpath = "//div[@class='sort__add']//button[2]")
	WebElement addContactBtn;

	@FindBy(css = ".custom-control-label span")
	WebElement selectAllContact;

	@FindBy(css = "button[class*=btn-success]")
	WebElement saveButton;

	@FindBy(css = ".modal-footer.footer-wrapper .btn.btn-success")
	WebElement saveListButton;

	@FindBy(css = ".pagination__results span")
	WebElement contactCount;

	public void createStaticList() {
		implicitlyWait(10);
		addListBtn.click();
		chooseStaticList.click();
		enterListName.sendKeys(listName);
		waitForElementToAppear(saveBtn, 2);
		saveBtn.click();
	}

	public String getTextMsg() {
		return listDetailsTitle.getText();
	}

	public void addContactInList() {
		implicitlyWait(10);
		addContactBtn.click();
		waitForElementToAppear(selectAllContact, 5);
		selectAllContact.click();
		saveButton.click();
		waitForElementToAppear(saveListButton, 5);
		saveListButton.click();

	}

	public int getAddedConCount() {

		waitForElementToAppear(contactCount, 5);
		String count = contactCount.getText();
		String[] temp = count.split("of");
		String[] conCount = temp[1].split(" ");
		String realCunt = conCount[1];
		int totalConCount = Integer.parseInt(realCunt);
		return totalConCount;
	}
}
