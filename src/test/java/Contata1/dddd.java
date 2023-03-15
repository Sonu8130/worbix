package Contata1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dddd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://d194qgwgpyjo8e.cloudfront.net/contacts#/list");
		driver.findElement(By.cssSelector("#user_name")).sendKeys("mikona@mailinator.com");
		driver.findElement(By.cssSelector("#user_password")).sendKeys("Worbix@1234");
		driver.findElement(By.cssSelector("button[type='button']")).click();
		WebElement element = driver.findElement(By.linkText("Contacts"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();

	}

}
