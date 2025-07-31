package stepDefinitions;
import io.cucumber.java.en.And;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.RequestManager;
import resources.RequestResources;
import resources.TestDataBuild;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static resources.Utils.GetRequestSpecification;

public class Steps {
    String userId;
    String token;
    String productId;
    String orderId;
    RequestSpecification request;
    Response response;


    @Given("username {string} and  password {string}")

    @Given("username {string} and password {string}")
    public void prepareValidLoginRequest(String userEmail, String userPassword) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        TestDataBuild data = new TestDataBuild();
        request= new RequestManager().prepareLoginRequest(userEmail,userPassword);


    }
    @When("sending {string} request to {string} with credentials")
    public void sendPostRequestToAPI(String httpMethod,String resource) throws IOException {
        switch (resource)
        {
            case "LoginAPI":
                break;
            case "AddProductAPI":
                request = new RequestManager().prepareAddProductRequest(userId, token);
                break;
            case "AddOrderAPI":
                request = new RequestManager().prepareAddOrderRequest(productId, token);
                break;
            case "GetOrderDetailsAPI":
                request = new RequestManager().prepareGetOrderDetailsRequest(orderId, token);
                break;
            case "DeleteProductAPI":
                request = new RequestManager().prepareDeleteProductRequest(productId, token);
                break;
            case "DeleteOrderAPI":
                request = new RequestManager().prepareDeleteOrderRequest(orderId, token);
                break;
            default:
                throw new IllegalArgumentException("Invalid resource: " + resource);
        }

        RequestResources resourceAPI = RequestResources.valueOf(resource);
        resource = resourceAPI.getResource();
        if(httpMethod.equalsIgnoreCase("POST")) {
            response = request.when().post(resource)
                    .then().extract().response();
        }
        else if(httpMethod.equalsIgnoreCase("GET")) {
            response = request.when().get(resource)
                    .then().extract().response();
        } else if (httpMethod.equalsIgnoreCase("DELETE")) {
            response = request.when().delete(resource)
                    .then().extract().response();
        } else {
            throw new IllegalArgumentException("Invalid HTTP method: " + httpMethod);

        }
    }

    @Then("response status code should be {int}")
    public void verifyResponseStatusCode(Integer statusCode){
        assertEquals(statusCode.intValue(), response.getStatusCode());
    }
    @Then("response should contain {string}")
    public void verifyResponseHasField(String fieldName) {
        JsonPath jsonPath = response.jsonPath();
        String fieldValue = jsonPath.getString(fieldName);
        if (fieldValue == null || fieldValue.isEmpty()) {
            throw new AssertionError("Response does not contain the expected field: " + fieldName);
        }
        switch (fieldName)
        {
            case "userId":
                userId = fieldValue;
                break;
            case "token":
                token = fieldValue;
                break;
            case "productId":
                productId = fieldValue;
                break;
            case "orders[0]":
                orderId = fieldValue;
                break;
            default:
                // Do nothing for other fields
                break;
        }
    }

    @Then("response {string} should contain {string}")
    public void verifyResponseFieldValue(String fieldName, String expectedValue) {
        JsonPath jsonPath = response.jsonPath();
        String actualValue = jsonPath.getString(fieldName);
        assertEquals(actualValue,expectedValue);
    }


    @And("response should contain {string} equals to {string}")
    public void responseShouldContainEqualsTo(String fieldJson, String varName) {
        JsonPath jsonPath = response.jsonPath();
        String actualResponseValue = jsonPath.getString(fieldJson);
        String actualValue = "";
        switch (varName)
        {
            case "userId":
                actualValue = userId;
                break;
            case "productId":
                actualValue= productId;
                break;
            default:
                break;
        }
        assertEquals(actualResponseValue,actualValue);
    }
}
