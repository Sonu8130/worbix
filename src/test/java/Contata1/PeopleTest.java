package Contata1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Contata.PageObjects.leftNavigation;
import Contata.PageObjects.people;
import Contata.TestComponents.BaseTest;

public class PeopleTest extends BaseTest {
	WebDriver driver;

	@Test
	public void TC_01_CreateContactTest() throws IOException, InterruptedException {
		leftNavigation leftnavigation = loginPage.loginApplication("mikona@mailinator.com", "Worbix@1234");
		people people = leftnavigation.goToContact();
		people.createContact();

	}

	@Test
	public void TC_2_DeletContact() {
		leftNavigation leftnavigation = loginPage.loginApplication("mikona@mailinator.com", "Worbix@1234");
		people people = leftnavigation.goToContact();
		people.deleteContact();
	}

	@Test
	public void TC_3_VerifyAddContactToGroup() {
		leftNavigation leftnavigation = loginPage.loginApplication("mikona@mailinator.com", "Worbix@1234");
		people people = leftnavigation.goToContact();
		people.addContactToGroup();
	}
}
