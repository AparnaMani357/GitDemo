package pagobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By login= By.linkText("Login");
	By Courses= By.cssSelector(".text-center>h2");
	By ContactLink=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(Courses);
	}
	
	public WebElement geContactLink()
	{
		return driver.findElement(ContactLink);
	}
}
