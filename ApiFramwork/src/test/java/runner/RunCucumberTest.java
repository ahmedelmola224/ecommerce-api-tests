package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        tags = "@e2e and @regression and @smoke",
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"}
)

public class RunCucumberTest {

}
