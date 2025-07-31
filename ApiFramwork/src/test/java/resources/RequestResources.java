package resources;

public enum RequestResources {
    LoginAPI("/api/ecom/auth/login"),
    AddProductAPI("/api/ecom/product/add-product"),
    AddOrderAPI("/api/ecom/order/create-order"),
    GetOrderDetailsAPI("/api/ecom/order/get-orders-details"),
    DeleteProductAPI("/api/ecom/product/delete-product/{id}"),
    DeleteOrderAPI("/api/ecom/order/delete-order/{id}");


    private final String resource;
    RequestResources(String resource) {
        this.resource = resource;
    }
    public String getResource() {
        return resource;
    }
}
