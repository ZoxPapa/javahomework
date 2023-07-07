import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        LinkedList<String> myList= new LinkedList<>();
        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        myList.add("Four");
        myList.add("Five");
        myList.add("Six");
        System.out.println(myList);
        System.out.println(reverseList(myList));
    }

    static LinkedList<String> reverseList (LinkedList<String> list){
        LinkedList<String> resultList = new LinkedList<>();
        ListIterator<String> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
            resultList.add(iterator.previous());
        }
        return  resultList;
    }
}