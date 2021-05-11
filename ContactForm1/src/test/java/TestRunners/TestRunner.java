package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src\\test\\java\\Features"},
		glue= {"StepDefinitions"},
		plugin= {"pretty","html:test-output/CucumberReport.html"},
		monochrome=true,
		dryRun=false
		)
public class TestRunner {

}
