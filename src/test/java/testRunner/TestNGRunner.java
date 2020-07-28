package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features"},
                glue = {"steps","utilities"},
                plugin = {"pretty","html:target/cucumber-report.html", "json:target/cucumber.json"})
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
