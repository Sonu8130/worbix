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

	String rndmStr = RandomStringUtils.randomNumeric(5);
	public String dlistName = "DynamicList_" + rndmStr;

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

	@FindBy(xpath = "(//a[@target='_self']/span)[2]")
	WebElement selectDynamicList;

	@FindBy(xpath = "(//span[@class='filter_add_icon'] //*[local-name()='svg'])[1]")
	WebElement clickOnExpand;

	@FindBy(xpath = "//label[starts-with(@for,'__BVID__')]")
	WebElement selectCategoryCheckbox;

	@FindBy(xpath = "(//div[@class='multiselect__select'])[1]")
	WebElement openCategoryDropdown;

	@FindBy(xpath = "//*[contains(text(),' Clients')]")
	WebElement selectCategory;

	@FindBy(css = ".title-input.sm.form-control")
	WebElement enterTitle;

	@FindBy(css = ".btn-success.btn-sm")
	WebElement saveDynamicList;

	@FindBy(css = "#name0")
	WebElement verifyListName;

	@FindBy(xpath = "//div[@class='shrinked__action__wrapper'] //*[local-name()='svg']")
	WebElement clickOn3Dot;

	@FindBy(xpath = "//div[@class='table__action__popout'] //li")
	WebElement clickOnDeleteButton;

	@FindBy(css = ".btn.btn-danger")
	WebElement confirmDelete;

	@FindBy(css = ".toast-body")
	WebElement deleteToastMsg;

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

	public String getDynamicListName() {
		return verifyListName.getText();
	}

	public void createDynamicList() {
		implicitlyWait(10);
		addListBtn.click();
		selectDynamicList.click();
		clickOnExpand.click();
		selectCategoryCheckbox.click();
		waitForElementToAppear(openCategoryDropdown, 5);
		openCategoryDropdown.click();
		waitForElementToAppear(selectCategory, 5);
		selectCategory.click();
		enterTitle.sendKeys(dlistName);
		saveDynamicList.click();
	}

	public void verifyDlistConCount() {
		createDynamicList();
		verifyListName.click();
		getAddedConCount();
	}

	public void verifyDeleteDlist() {
		createDynamicList();
		clickOn3Dot.click();
		waitForElementToAppear(clickOnDeleteButton, 5);
		clickOnDeleteButton.click();
		confirmDelete.click();
	}

	public String getDlistDeleteToastMsg() {
		waitForElementToAppear(deleteToastMsg, 5);
		return deleteToastMsg.getText();
	}

}
