package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		glue="steps",
		features="src\\test\\resources\\features",
		tags="@wip0603",
		monochrome=true,
		stepNotifications=true,
		plugin= {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
		dryRun=false
		
		)
public class RegRunner {

}
