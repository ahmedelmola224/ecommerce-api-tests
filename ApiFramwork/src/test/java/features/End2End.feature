Feature: End-to-End E-commerce API testing
@smoke @regression @e2e
  Scenario: Full e-commerce flow test

    Given username "ahmedelmola224@gmail.com" and password "123456@Ahmed"
    When sending "POST" request to "LoginAPI" with credentials
    Then response status code should be 200
    And response should contain "token"
    And response should contain "userId"
    And response "message" should contain "Login Successfully"

    When sending "POST" request to "AddProductAPI" with credentials
    Then response status code should be 201
    And response should contain "productId"
    And response "message" should contain "Product Added Successfully"

    When sending "POST" request to "AddOrderAPI" with credentials
    Then response status code should be 201
    And response should contain "orders[0]"
    And response "message" should contain "Order Placed Successfully"

    When sending "GET" request to "GetOrderDetailsAPI" with credentials
    Then response status code should be 200
    And response should contain "data.orderById" equals to "userId"
    And response should contain "data.productOrderedId" equals to "productId"
    And response "message" should contain "Orders fetched for customer Successfully"

    When sending "DELETE" request to "DeleteOrderAPI" with credentials
    Then response status code should be 200
    And response "message" should contain "Orders Deleted Successfully"

    When sending "DELETE" request to "DeleteProductAPI" with credentials
    Then response status code should be 200
    And response "message" should contain "Product Deleted Successfully"