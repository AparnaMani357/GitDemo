package UdemyAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pagobject.LandingPage;
import pagobject.LoginPage;
import resources.base;

public class ValidateNavigation extends base {
	private static Logger log= LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver=getDriver();
		prop.load(fs);
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validationOfNavigation()
	{
		LandingPage lp= new LandingPage(driver);
		Assert.assertTrue(lp.geContactLink().isDisplayed());
		log.info("Contact link available");
	}
	
	@AfterTest
	public void CloseConnection()
	{
		driver.quit();
	}
}
