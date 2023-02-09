package Jio_saavn.Jio_saavn_Testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JioSaavn_Testing {

	@Test
	public void Testing_Jiosaavn() throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jiosaavn.com/");
		List<WebElement> count = driver.findElements(By.xpath("(//div[@class='o-block__img'])"));
		System.out.println(count.size());
		for (int i = 1; i <= 5; i++) {
			Actions actions = new Actions(driver);
			WebElement playbutton = driver.findElement(By.xpath("(//div[@class='o-block__img'])[" + i + "]"));
			actions.moveToElement(playbutton).click().build().perform();
			Thread.sleep(5000);
		}
		Actions actions = new Actions(driver);
		WebElement playbutton = driver.findElement(By.xpath("(//div[@class='o-block__img'])[1]"));
		actions.moveToElement(playbutton).click().build().perform();
		WebElement element=driver.findElement(By.xpath("(//section[@class='c-progress'])[1]"));
		int width=element.getSize().getWidth();
		actions.moveToElement(element).moveByOffset((width/2)-2, 0).click().perform();
		Thread.sleep(2000);
		actions.moveToElement(element).moveByOffset((width/4)-2, 0).click().perform();
		Thread.sleep(2000);
		actions.moveToElement(element).moveByOffset((width/4)-2, 0).click().perform();
		Thread.sleep(2000);
		actions.moveToElement(element).moveByOffset((width/5)-2, 0).click().perform();
		Thread.sleep(2000);
		actions.moveToElement(element).moveByOffset((width/9)-2, 0).click().perform();
		Thread.sleep(2000);
		actions.moveToElement(element).moveByOffset((width/2)-2, 0).click().perform();
		Thread.sleep(2000);
		actions.moveToElement(element).moveByOffset((width/4)-2, 0).click().perform();
		Thread.sleep(2000);
		actions.moveToElement(element).moveByOffset((width/5)-2, 0).click().perform();
		Thread.sleep(2000);
		actions.moveToElement(element).moveByOffset((width/3)-2, 0).click().perform();
		Thread.sleep(2000);
		actions.moveToElement(element).moveByOffset((width/8)-2, 0).click().perform();
		Thread.sleep(2000);
		actions.moveToElement(element).moveByOffset((width/2)-2, 0).click().perform();
	}
}
