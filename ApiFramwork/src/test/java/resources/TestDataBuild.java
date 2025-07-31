package resources;

import pojo.LoginRequest;
import pojo.Orders;
import pojo.OrdersPayload;

import static java.util.List.of;

public class TestDataBuild {
    public LoginRequest LoginPayload(String email, String password)
    {
       return new LoginRequest(email, password);
    }

    public OrdersPayload ordersPayload(String productId)
    {
        Orders order= new Orders();
        order.setCountry("Pakistan");
        order.setProductOrderedId(productId);
        return new OrdersPayload(of(order));

    }


}
