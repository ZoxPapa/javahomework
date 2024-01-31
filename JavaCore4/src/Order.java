import customexceptions.IncorrectQuantityException;

import java.io.FileReader;
import java.util.List;

public class Order {
    private int orderID = counter;

    static private int counter = 1;

    private Customer orderOwner;
    private Product product;
    int qty;
    private int orderPrice;
    @Override
    public String toString() {
        return "Order #"+ orderID +
                ", product=" + product +
                ", qty=" + qty +
                ", orderPrice=" + orderPrice +
                '}';
    }

    public int getOrderID() {
        return orderID;
    }

    public Product getProduct() {
        return product;
    }

    public Customer getOrderOwner() {
        return orderOwner;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getQty() {
        return qty;
    }

    public Order(Customer orderOwner, Product product, int qty) {
        this.orderOwner = orderOwner;
        this.product = product;
        this.orderPrice = product.getPrice()*qty;
        this.qty = qty;
        counter++;
    }
}
