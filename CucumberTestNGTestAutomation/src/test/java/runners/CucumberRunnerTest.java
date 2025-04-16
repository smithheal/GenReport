package runners;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "classpath:features", tags = "@Login or @ForgotPassword", glue = {
				"driverfactory", "hooks", "pagefactory", "runners",
				"stepdefinitions"}, plugin = {"pretty",
						"json:target/cucumber-reports/cucumber.json",
						"html:target/cucumber-reports/cucucmber-report.html",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true)

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Inside TestNG @AfterSuite Annotation....!!!");
	}
}
