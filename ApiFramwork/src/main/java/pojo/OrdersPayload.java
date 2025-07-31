package pojo;
import java.util.List;
import pojo.Orders.*;
public class OrdersPayload {


        private List<Orders> orders;

        public OrdersPayload() {
        }

        public OrdersPayload(List<Orders> orders) {
            this.orders = orders;
        }

        public List<Orders> getOrders() {
            return orders;
        }

        public void setOrders(List<Orders> orders) {
            this.orders = orders;
        }
    }


