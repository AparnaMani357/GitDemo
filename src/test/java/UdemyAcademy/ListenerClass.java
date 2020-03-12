package UdemyAcademy;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.base;

public class ListenerClass implements ITestListener  {
	
	base b= new base();
	
	public void onTestFailure(ITestResult result)
	{
		
		try {
			b.getScreenshots(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
