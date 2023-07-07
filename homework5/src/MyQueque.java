import java.util.LinkedList;

public class MyQueque {
    LinkedList<String> queque = new LinkedList<>();
    Integer size;

    void enqueue(String item){
    queque.add(item);
    }

    String dequeue(){
        String firstItem = queque.get(0);
        queque.removeFirst();
    return firstItem;
    }

    String first(){
        String firstItem = queque.get(0);
        return firstItem;
    }
    void printing(){
        for (String item:queque) {
            System.out.println(item);
        }
    }

}
