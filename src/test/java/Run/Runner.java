package Run;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@AuthentificationOrangeHRM",
		features = "src/test/feature/Test",
		glue = "TestCucumber",
		publish = true,
		plugin = {"pretty","html:target/cucumber_report.html","json:target/cucumber-report"
				,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		
		)






public class Runner {

}
