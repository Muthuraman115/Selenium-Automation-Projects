package RedBus_PageObjectModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedBus_Home_Page {
	WebDriver driver;
	public RedBus_Home_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='src']")
	WebElement Fromcity;
	@FindBy(xpath="//input[@id='dest']")
	WebElement Tocity;
	@FindBy(xpath="//ul[@class='autoFill homeSearch']/child::li")
	List<WebElement> selectdropdowncities;
	@FindBy(css=".monthTitle")
	WebElement Month;
	@FindBy(xpath="(//button[normalize-space()='>'])[1]")
	WebElement nextpagebutton;
	@FindBy(xpath="//button[@id='search_btn']")
	WebElement searchbutton;
	String fromcity="Chen";
	String selectfromcity="Thiruvanmiyur, Chennai";
	String tocity="Tri";
	String selecttocity="Trichy";
	String findmonth="Mar";
	String finddate="11";
	public void selectfromandtocities()
	{
		Fromcity.sendKeys(fromcity);
		List<WebElement> fromcity=selectdropdowncities;	
		selectcity(fromcity,selectfromcity);
		Tocity.sendKeys(tocity);
		List<WebElement> tocity=selectdropdowncities;	
		selectcity(tocity,selecttocity);
	}
	public void loadhomepage()
	{
		driver.get("https://www.redbus.in/");
	}
	public void selectcity(List<WebElement> webelementcity,String city)
	{
		for(WebElement extracted:webelementcity)
		{
			if(extracted.getText().equalsIgnoreCase(city))
			{
				extracted.click();
				break;
			}
		}
	}
	public void selectcalendar()
	{
		String month=Month.getText().split(" ")[0];
		while(month!=findmonth)
		{
			if(month.equalsIgnoreCase(findmonth))
			{
				break;
			}
			else
			{
				nextpagebutton.click();
				month=Month.getText().split(" ")[0];
			}
		}
		
		for(int i=3;i<=8;i++)
		{
			List<WebElement> calendar=driver.findElements(By.xpath("//tr[position()="+i+"]/child::td"));
			for(WebElement extracted:calendar)
			{
				if(extracted.getText().equalsIgnoreCase(finddate))
				{
					extracted.click();
				}
			}
		}
	}
	public void selectbutton()
	{
		searchbutton.click();
	}
}
