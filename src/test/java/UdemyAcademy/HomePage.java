package UdemyAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagobject.LandingPage;
import pagobject.LoginPage;
import resources.base;

public class HomePage extends base {
	private static Logger log= LogManager.getLogger(HomePage.class.getName());
	
	
	
	@BeforeMethod
	public void Initialize() throws IOException
	{
		driver=getDriver();
		log.info("Browser opened successfully");
		
		prop.load(fs);
		driver.get(prop.getProperty("url"));
		log.info("URL opened successfully");
	}
	

	
	@Test(dataProvider="getCredentials")
	public void initializeBrowser(String UserName, String Pwd) throws IOException
	{
		/*driver=getDriver();
		prop.load(fs);
		driver.get(prop.getProperty("url"));*/
		
		
		LandingPage lp= new LandingPage(driver);
		lp.getLogin().click();
		log.info("clicked on login");
		
		LoginPage login= new LoginPage(driver);
		login.getEmail().sendKeys(UserName);
		login.getPassword().sendKeys(Pwd);
		login.getLogButton().click();
		
		log.info("URL opened successfully with"+UserName);
		

	}
	
	@DataProvider
	
	public Object[][] getCredentials()
	{
		Object[][] credentials= new Object[2][2];
		
		//FirstUser
		credentials[0][0]="user1@gamil.com";
		credentials[0][1]="user123";
		
		//SecondUser
		credentials[1][0]="user2@gamil.com";
		credentials[1][1]="user223";
		
		return credentials;
	}
	
	@AfterMethod
	public void CloseConnection()
	{
		driver.quit();
	}

}
