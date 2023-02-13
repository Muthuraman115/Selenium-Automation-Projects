package JQuery_components_testing_basetest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import JQuery_Components_POM_Data_Management.Data_Management_File_Manager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest_Data_Management {
	WebDriver driver;
	Data_Management_File_Manager file;
	public WebDriver initialize()
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public void gotofilemanager() throws InterruptedException
	{
		driver=initialize();
		file=new Data_Management_File_Manager(driver);
		file.gotofilemanagerURL();
		file.openfilemanager();
		file.newfolder();
	}
}
