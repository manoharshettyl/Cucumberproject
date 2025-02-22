package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testcontext;
	public Hooks(TestContext context)
	{
		
		testcontext= context;
		
	}
	
	
	@Before
	public void beforeScenario(Scenario Scenario)
	{
		
		Reporter.assignAuthor("Manohar ");
	}
	
	
	@After(order=1)
	public void afterScenario(Scenario scenario)
		{
			if(scenario.isFailed())
			{
				
				String screenshotName=scenario.getName().replaceAll(" ","_");
				try
				{
					File sourcePath= ((TakesScreenshot) testcontext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
					
					File destinationPath= new File("D:/Workspace/CucumberProject/target/cucumber-reports/screenshots/"+screenshotName+ System.currentTimeMillis()+".png");
				
				Files.copy(sourcePath,destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
				}
				catch(IOException e) {
					
					e.printStackTrace();
				}
				}
				
				
			}
			
			
			
		
		
		
	
	
	@After(order=0)
	public void afterSteps()
	{
		testcontext.getWebDriverManager().closeDriver();
		
	}
}
