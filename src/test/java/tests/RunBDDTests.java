package tests;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

/**
 * Created by spasham@planittesting.com
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = {"steps"},
		plugin = { "html:target/reports/cucumber-html-report",
				   "json:target/reports/cucumber.json",
				   "junit:target/reports/cucumber-results.xml",
				   "pretty:target/reports/cucumber-pretty.txt"}
		)

public class RunBDDTests {}

