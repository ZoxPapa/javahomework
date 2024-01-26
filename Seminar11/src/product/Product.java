package product;

public abstract class Product {
    private String name;
    private int price;


    public Product (String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "product.Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
