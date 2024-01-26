package product;

public class Phone extends Product {
    String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Phone(String name, int price) {
        super(name, price);
    }
    public Phone(String name, int price, String color) {
        super(name, price);
        this.color = color;
    }
}
