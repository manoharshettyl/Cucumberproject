package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FunctionalTests", glue = { "stepDefinitions" }, plugin = { "pretty",
		"json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, monochrome = true)
public class TestRunner {

	@AfterClass
	public static void writeExtentReport() {

		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigFileReader().getReportConfigPath()));
Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
Reporter.setSystemInfo("Machine", "windows 10"+"64 Bit");
Reporter.setSystemInfo("Selenium", "3.12.0");
Reporter.setSystemInfo("Maven", "3.5.2");
Reporter.setSystemInfo("Java Version", "1.8");


	}

}
