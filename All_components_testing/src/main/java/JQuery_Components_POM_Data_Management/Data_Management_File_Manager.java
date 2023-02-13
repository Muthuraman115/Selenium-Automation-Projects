package JQuery_Components_POM_Data_Management;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Data_Management_File_Manager {

	WebDriver driver;

	public Data_Management_File_Manager(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href*='filemanager']")
	WebElement filemanager;
	@FindBy(xpath = "//span[@class='k-button-text'][normalize-space()='New Folder']")
	WebElement Newfolder;
	@FindBy(xpath = "(//span[@class='k-treeview-leaf k-in'])")
	List<WebElement> listofnewfolder;
	@FindBy(xpath="//span[@class='kd-loader']")
	WebElement loader;
	@FindBy(xpath="//button[@aria-label='Upload']")
	WebElement upload;
	@FindBy(xpath="(//input[@name='file'])[2]")
	WebElement selectfile;
	@FindBy(xpath="//button[.='Done']")
	WebElement done;
	public void gotofilemanagerURL() {
		driver.get(
				"https://demos.telerik.com/kendo-ui/?_ga=2.116995650.573854851.1676180766-1001462378.1676180766&_gl=1*6egocw*_ga*MTAwMTQ2MjM3OC4xNjc2MTgwNzY2*_ga_9JSNBCSF54*MTY3NjIwNzI2OS40LjAuMTY3NjIwNzI2OS42MC4wLjA.");
	}

	public void openfilemanager() {
		String clicklnk = Keys.chord(Keys.CONTROL, Keys.ENTER);
		filemanager.sendKeys(clicklnk);
	}

	public void newfolder() throws InterruptedException {
		// window handles
		Set w = driver.getWindowHandles();
		// window handles iterate
		Iterator t = w.iterator();
		String pw = (String) t.next();
		String ch = (String) t.next();
		// switching child window
		driver.switchTo().window(ch);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(Newfolder));
		Thread.sleep(1000);
		Newfolder.click();
		Thread.sleep(1000);
		List<WebElement> newfolder = listofnewfolder;
		uploadinnewfolder(newfolder);
	}
	public void uploadinnewfolder(List<WebElement> rename) throws InterruptedException
	{
		for(WebElement extracted:rename)
		{
			if(extracted.getText().equalsIgnoreCase("New Folder"))
			{
				JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
				javaScriptExecutor.executeScript("arguments[0].click()", extracted);
				upload.click();
				selectfile.sendKeys(System.getProperty("user.dir")+"//resources//image.jpg");
				Thread.sleep(2000);
				done.click();
			}	
		}
	}

	
}
