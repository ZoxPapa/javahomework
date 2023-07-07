import java.util.Iterator;
import java.util.LinkedList;

public class Main2 {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();
        myList.add(1);
        myList.add(2);
        myList.add(7);
        myList.add(1);
        System.out.println(sumOfItems(myList));
    }

    static int sumOfItems (LinkedList<Integer> myList){
        Integer result = 0;
        Iterator<Integer> myIterator = myList.iterator();
        while (myIterator.hasNext()){
            result += myIterator.next();
        }
        return result;
    }
}
