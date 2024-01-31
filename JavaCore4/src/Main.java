import customexceptions.IncorrectQuantityException;
import customexceptions.UnavailableProductException;
import customexceptions.UnknownCustomerException;

import java.io.FileWriter;
import java.util.Scanner;

/**Внимание: во время возникновения ошибок в данных (исключений),
необходимо будет повторно вводить данные с клавиатуры.
 **/

public class Main {
    static ProductsList products = new ProductsList();
    public static void main(String[] args) {
//        Создание сущностей покупателей и товаров
        Customer bob = new Customer(Sex.MALE, "Bob");
        Customer max = new Customer(Sex.MALE, "Max");
        Customer lisa = new Customer(Sex.FEMALE, "Lisa");
        Customer thief = new Customer(Sex.FEMALE, "Thief");
        Product apple = new Product("Apple", 10);
        Product banana = new Product("Banana",12);
        Product orange = new Product("Orange", 15);
        Product pineapple = new Product("Pineapple", 200);

//          Добавление потенциальных покупателей в базу
        Customer.addCustomer(bob);
        Customer.addCustomer(max);
        Customer.addCustomer(lisa);
//          Создание массива с товарамами
// TODO: массив пришлось в статику выводить. Как можно по-другому его сообщить методу проверки соответствия продукта?
        products.add(apple); products.add(banana); products.add(orange);
//          Создание заказов
        makeOrder(bob, apple, 2);
        makeOrder(thief, orange, 10); //заказ с отсутствующим в БД покупателем
        makeOrder(lisa, banana, 200);
        makeOrder(lisa, pineapple,4); //заказ с отсутствующим товаром
        makeOrder(bob, banana,-14); //заказ с отрицательным количеством товаров

        //проверка информативности исключения по количеству
//        try{
//            checkQty(-1);
//        }catch (IncorrectQuantityException e){
//            e.printStackTrace();
//        }
        //проверка информативности исключения по наличию товара
//        try{
//            checkProduct(pineapple);
//        }catch (UnavailableProductException e){
//            e.printStackTrace();
//        }
        //проверка информативности исключения по покупателю
//        try{
//            thief.checkCustomer(thief);
//        }catch (UnknownCustomerException e){
//            e.printStackTrace();
//        }
    }
    static Order makeOrder(Customer customer, Product product, int qty){
        try {
            if (customer.checkCustomer(customer)
            && checkQty(qty)
            && checkProduct(product)) {
                Order order = new Order(customer, product, qty);
                writeOrderToDB(order);
                return order;
            }
        }catch (UnknownCustomerException e) {
            System.out.println("Name: "+ customer.getName()+" is not correct, please input correct customer name.");
            Scanner sc = new Scanner(System.in);
            customer = new Customer(customer.getSex(), sc.nextLine());
        }catch (IncorrectQuantityException e){
            System.out.println(qty+ " - it's incorrect quantity of products. Please input positive number.");
            Scanner sc = new Scanner(System.in);
            qty = sc.nextInt();
        }catch (UnavailableProductException e){
            boolean flag = true;
            String productName = product.getName();
            while(flag) {
                System.out.println(productName + " is absent in our store. Please input correct product name: ");
                Scanner sc = new Scanner(System.in);
                productName = sc.nextLine();
                for (Object product1 : products) {
                    if (((Product) product1).getName().equals(productName)) {
                        product = (Product) product1;
                        flag = false;
                    }
                }
            }
        }

        return makeOrder(customer, product, qty);
    }
    static void writeOrderToDB (Order order){
        try(FileWriter fw = new FileWriter("orders_db.txt", true)){
            fw.write("ID: " + order.getOrderID() +", "+
                    "customer: "+order.getOrderOwner().getName() + ", "+
                    "product: "+order.getProduct() + ", " +
                    "qty: " +order.getQty() + ", " +
                    "totalOrderPrice: "+ order.getOrderPrice() + "\n");
        }catch (Exception e){
            System.out.println("All exceptions");
            e.printStackTrace();
        }
        System.out.printf("Order %s successfully created%n", order.getOrderID());
    }

    static boolean checkQty (int qty) throws IncorrectQuantityException {
        if(qty>0) return true;
        throw new IncorrectQuantityException("Incorrect quantity of products. Needs to be >0. Actually: "+ qty);
    }

    static boolean checkProduct (Product product) throws UnavailableProductException{
        if(products.contains(product)){
            return true;
        }throw new UnavailableProductException ("Product " + product +" is absent in our store");
    }
}