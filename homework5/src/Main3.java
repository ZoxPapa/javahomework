public class Main3 {
    public static void main(String[] args) {
        MyQueque test1 = new MyQueque();
        test1.enqueue("Some Item");
        test1.enqueue("Another Item");
        test1.enqueue("Third Item");
        test1.enqueue("4 Item");
        test1.enqueue("5 Item");
        test1.enqueue("Last Item");
        test1.printing();
        System.out.println(test1.dequeue());
        System.out.println("\n");
        test1.printing();
        System.out.println("\n");
        System.out.println(test1.first());
        System.out.println("\n");
        test1.printing();
    }
}
