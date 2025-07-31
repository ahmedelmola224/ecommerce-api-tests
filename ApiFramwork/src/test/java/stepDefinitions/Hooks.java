package stepDefinitions;
import io.cucumber.java.Before;
import resources.TestDataBuild;


import java.io.IOException;

import static io.restassured.RestAssured.given;
import static resources.Utils.GetRequestSpecification;

public class Hooks {
    // This class can be used to set up hooks for Cucumber tests, such as before and after scenarios.
    // For example, you can use it to initialize resources or clean up after tests.


    public void beforeScenario() throws IOException {
    }
}
