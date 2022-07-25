package entities;

import entities.enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;

    private Client client;

    private List<OrderItem>items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }
    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        double sum = 0;
        for (OrderItem o : items) {
            sum += o.subTotal();
        }
        return sum;
    }
}
