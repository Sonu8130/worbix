package Contata.PageObjects;

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

	String listName = "NewGenricList";
	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement addListBtn;

	@FindBy(xpath = "//li[@role='presentation'][1] //a[@role='menuitem']/span")
	WebElement chooseStaticList;
	@FindBy(css = ".form-control")
	WebElement enterListName;
	@FindBy(css = ".modal-footer button:last-child")
	WebElement saveBtn;
	@FindBy(css = ".contact__name")
	WebElement listTitle;

	public void createStaticList() {
		implicitlyWait(2);
		addListBtn.click();
		chooseStaticList.click();
		enterListName.sendKeys(listName);
		waitForElementToAppear(saveBtn, 2);
		saveBtn.click();
		Assert.assertEquals(listTitle.getText(), listName);

	}

}
