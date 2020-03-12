package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	public FileInputStream fs ;
	
	public WebDriver getDriver() throws IOException
	{
			
	 prop= new Properties();
	 
	
	 fs =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	
	prop.load(fs);
	
	//String BrowserName=prop.getProperty("browser");
	
	String BrowserName=System.getProperty("browser");
	
	if(BrowserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		
		//to run headless
		ChromeOptions options= new ChromeOptions();
		options.addArguments("headless");
		driver= new ChromeDriver(options);
	}
	
	else if(BrowserName.equalsIgnoreCase("firefox"))
	{
		//Write code for firefox driver
	}
	
	else if (BrowserName.equalsIgnoreCase("ie")) 
	
	{
		//Write code for IE driver
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
	
	}

	public void getScreenshots(String result) throws IOException
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\User\\Desktop\\SeleniumJars\\ScreenShots\\"+result+"FailedScreenshot.png"));
	}
	
}
