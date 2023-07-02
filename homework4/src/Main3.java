import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main3 {
    public static void main(String[] args) {
        List<String> planetsAll = new ArrayList<>();
        planetsAll.add("Mercury");
        planetsAll.add("Venus");
        planetsAll.add("Earth");
        planetsAll.add("Mars");
        planetsAll.add("Jupiter");
        planetsAll.add("Saturn");
        planetsAll.add("Uranus");
        planetsAll.add("Neptune");
        List<String> planetsRandomList = fillingPlanets(planetsAll);
        System.out.println(planetsRandomList);
        finder(planetsRandomList);
    }

    static Integer myRandom(){
        Random myRandomizer = new Random();
        return (myRandomizer.nextInt(9));
    }
    static List<String> fillingPlanets (List<String> base){
        List<String> planets = new ArrayList<>();
        for (String planet:base) {
            for (int i = 0; i < myRandom(); i++) {
                planets.add(planet);
            }
        }
        return planets;
    }

    static void finder (List<String> someList){
        List<String> result = new ArrayList<>();
        for (String item:someList) {
            if(!result.contains(item)){
                System.out.printf("There are %s %s planets in the list.\n",
                        Collections.frequency(someList, item), item);
                result.add(item);
            }
        }
    }
}
