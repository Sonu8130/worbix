package Contata.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void implicitlyWait(int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));

	}

	public void goTo() {
		driver.get("http://worbix.contata.co.in");
	}

	public void mouseHover(WebElement targetElement) {
		Actions actions = new Actions(driver);
		actions.moveToElement(targetElement).build().perform();
	}

	public void waitForElementToAppear(By ele, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}

	public void waitForElementToAppear(WebElement ele, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForElementToAppear(List<WebElement> ele, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	
	public void waitForElementToDisappear(WebElement ele, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void scrollPage() {
		// To perform scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(1078,653)", "");
	}
}
