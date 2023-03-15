package Contata1;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Contata.PageObjects.leftNavigation;
import Contata.TestComponents.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginTest() throws IOException, InterruptedException {

		leftNavigation leftnavigation = loginPage.loginApplication("mikona@mailinator.com", "Worbix@1234");
		
		leftnavigation.goToContact();
	}


}
