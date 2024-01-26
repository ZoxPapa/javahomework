package vending_machine;

import product.HotDrink;
import java.util.ArrayList;
import java.util.List;
import product.*;

public class PhoneVendingMachine implements VendingMachine{
    List<Phone> phoneList;
    int money;


    public Phone getProduct (String name){
        for (Phone product: phoneList) {
            if(product.getName().equals(name)){
                money += product.getPrice();
                return product;
            }
        }
        return null;
    }
    public PhoneVendingMachine() {
        this.phoneList = initProduct();
        this.money = 0;
    }


    private List<Phone> initProduct(){
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone("Samsung", 10));
        phoneList.add(new Phone("IPhone", 100, "White"));
        return phoneList;
     }
}
