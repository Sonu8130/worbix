package Contata1;

import org.testng.Assert;
import org.testng.annotations.Test;

import Contata.PageObjects.ListModule;
import Contata.PageObjects.leftNavigation;
import Contata.TestComponents.BaseTest;
import Contata.TestComponents.Retry;

public class listPgaeTests extends BaseTest {

	@Test
	public void TC_04_VerifyCreateStaticListName() {
		leftNavigation leftnavigation = loginPage.loginApplication("mikona@mailinator.com", "Worbix@1234");
		ListModule listModule = leftnavigation.goToList();
		listModule.createStaticList();
		Assert.assertEquals(listModule.getTextMsg(), listModule.listName);
	}

	@Test(retryAnalyzer = Retry.class)
	public void TC_05_VerifyAddConatctToStaticList() {
		leftNavigation leftnavigation = loginPage.loginApplication("mikona@mailinator.com", "Worbix@1234");
		ListModule listModule = leftnavigation.goToList();
		listModule.createStaticList();
	}

	@Test
	public void TC_05_VerifyContactCount() {
		leftNavigation leftnavigation = loginPage.loginApplication("mikona@mailinator.com", "Worbix@1234");
		ListModule listModule = leftnavigation.goToList();
		listModule.createStaticList();
		listModule.addContactInList();
		int totalConCount = listModule.getAddedConCount();

		if (totalConCount < 0) {
			Assert.assertTrue(false);
		} else
			Assert.assertTrue(true);
	}

	@Test
	public void TC_06_VerifyCreateDynamicListName() {
		leftNavigation leftnavigation = loginPage.loginApplication("mikona@mailinator.com", "Worbix@1234");
		ListModule listModule = leftnavigation.goToList();
		listModule.createDynamicList();
		Assert.assertEquals(listModule.getDynamicListName(), listModule.dlistName);
	}

	@Test
	public void TC_07_VerifyContactCountInDynamicList() {
		leftNavigation leftnavigation = loginPage.loginApplication("mikona@mailinator.com", "Worbix@1234");
		ListModule listModule = leftnavigation.goToList();
		listModule.verifyDlistConCount();
		int totalConCount = listModule.getAddedConCount();

		if (totalConCount < 0) {
			Assert.assertTrue(false);
		} else
			Assert.assertTrue(true);
	}

	@Test
	public void TC_08_VerifyDeleteDynamicList() {
		leftNavigation leftnavigation = loginPage.loginApplication("mikona@mailinator.com", "Worbix@1234");
		ListModule listModule = leftnavigation.goToList();
		listModule.verifyDeleteDlist();
		Assert.assertEquals(listModule.getDlistDeleteToastMsg(), "List deleted successfully.");
	}

}
