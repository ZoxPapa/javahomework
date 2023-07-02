import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> someList = new ArrayList<>();
        someList.add(12);
        someList.add(11);
        someList.add(17);
        someList.add(10);
        someList.add(129);
        someList.add(1);
        someList.add(128);
        System.out.println(Collections.max(someList));
        System.out.println(Collections.min(someList));
        System.out.println(average(someList));
    }

    private static float average(List<Integer> someList) {
        float mySum = 0;
        for (int i = 0; i < someList.size(); i++) {
            mySum+= someList.get(i);
        }
        return mySum/someList.size();
    }


}
