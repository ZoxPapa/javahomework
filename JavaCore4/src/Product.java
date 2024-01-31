import java.util.ArrayList;

public class Product {
//    static public ArrayList<Product> productList;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
