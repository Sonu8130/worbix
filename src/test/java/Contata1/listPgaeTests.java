package Contata1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Contata.PageObjects.ListModule;
import Contata.PageObjects.leftNavigation;
import Contata.TestComponents.BaseTest;

public class listPgaeTests extends BaseTest {
	WebDriver driver;

	@Test
	public void TC_03_CreateStaticList() {
		leftNavigation leftnavigation = loginPage.loginApplication("mikona@mailinator.com", "Worbix@1234");
		ListModule listModule = leftnavigation.goToList();
		listModule.createStaticList();
		Assert.assertEquals(listModule.listActual, listModule.listName);
	}

}
