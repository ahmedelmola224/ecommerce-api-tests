package resources;

import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RequestManager {
    // This class can be used to manage request specifications, if needed.

    public RequestSpecification prepareLoginRequest(String email, String password) throws IOException {
        TestDataBuild data = new TestDataBuild();
        return given().spec(Utils.GetRequestSpecification())
                .contentType(io.restassured.http.ContentType.JSON)
                .body(data.LoginPayload(email, password));
    }
    public RequestSpecification prepareAddProductRequest(String userId,String token) throws IOException {
        return given().spec(Utils.GetRequestSpecification())
                .header("Authorization",token)
                .formParam("productName", "Sample Product")
                .formParam("productAddedBy",userId)
                .formParam("productCategory","fashion")
                .formParam("productSubCategory","shirts")
                .formParam("productPrice", "100")
                .formParam("productDescription", "Sample Description")
                .formParam("productFor","men")
                .multiPart("productImage",new File("/home/ahmed/Postman/files/shirt.jpeg"));
    }
    public RequestSpecification prepareAddOrderRequest(String productId, String token) throws IOException {
        TestDataBuild data = new TestDataBuild();
        return given().spec(Utils.GetRequestSpecification())
                .header("Authorization", token)
                .contentType(io.restassured.http.ContentType.JSON)
                .body(data.ordersPayload(productId));
    }
    public RequestSpecification prepareGetOrderDetailsRequest(String orderId, String token) throws IOException {
        return given().spec(Utils.GetRequestSpecification())
                .header("Authorization", token)
                .queryParam("id", orderId);
    }

    public RequestSpecification prepareDeleteProductRequest(String productId, String token) throws IOException {
        return given().spec(Utils.GetRequestSpecification())
                .header("Authorization", token)
                .pathParam("id", productId);
    }

    public RequestSpecification prepareDeleteOrderRequest(String orderId, String token) throws IOException {
        return given().spec(Utils.GetRequestSpecification())
                .header("Authorization", token)
                .pathParam("id", orderId);
    }


}
