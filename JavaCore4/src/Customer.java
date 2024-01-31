import customexceptions.UnknownCustomerException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Customer {
    static private List<Customer> customerList;
    private Sex sex;
    private String name;

    public Customer(Sex sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    static public void addCustomer(Customer customer){
        try(FileWriter fw = new FileWriter("customers_db.txt", true)){
            fw.write(customer.name +"\n");
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(String.format("Customer %s successfully created", customer.name));

    }
    boolean checkCustomer (Customer customer) throws UnknownCustomerException {
        try(FileReader fr = new FileReader("customers_db.txt")){
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()){
                if(sc.nextLine().equals(customer.getName())){
                    return true;
                }
            }
            throw new UnknownCustomerException(customer.getName()+" not in the customers DataBase");
        }catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
