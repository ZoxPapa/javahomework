import java.util.ArrayList;
import java.util.List;

public class HotDrinkVendingMachine implements VendingMachine{
    private List<HotDrink> hotDrinkList;

    public HotDrinkVendingMachine() {
        this.hotDrinkList = initMachine();
    }

    @Override
    public HotDrink getProduct(String name) {
        for(HotDrink hotDrink: hotDrinkList){
            if (hotDrink.getName().equals(name)){
                return hotDrink;
            }
        }
        return null;
    }
    public HotDrink getProduct(String name, int temperature){
        for(HotDrink hotDrink: hotDrinkList){
            if (hotDrink.getName().equals(name) && hotDrink.getTemperature() == temperature){
                return hotDrink;
            }
        }
        return null;
    }


    private List<HotDrink> initMachine(){
        List<HotDrink> drinksList = new ArrayList<>();
        drinksList.add(new HotDrink("Latte", 150));
        drinksList.add(new HotDrink("WhiteCoffe", 100, 40));
        return drinksList;
    }
}
