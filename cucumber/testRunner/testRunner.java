package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        plugin = { "pretty" ,"html:target/cucumber-output/cucumberreport.html"},
        tags = "@activity5"
)
public class TestRunner {

}