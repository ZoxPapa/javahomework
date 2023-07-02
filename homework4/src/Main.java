import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> someList = new ArrayList<>();
        someList.add(12);
        someList.add(11);
        someList.add(17);
        someList.add(10);
        someList.add(129);
        someList.add(1);
        someList.add(128);
//        System.out.println(someList);
        someList = evenDelete(someList);
        System.out.println(someList);

    }
    static ArrayList<Integer> evenDelete (List <Integer> myList){
        ArrayList<Integer> resultList = new ArrayList<>();
        for (Integer i = myList.size()-1; i >= 0; i--) {
            if(myList.get(i) %2 != 0) {
                resultList.add(myList.get(i));
            }
        }
        return resultList;
    }
}