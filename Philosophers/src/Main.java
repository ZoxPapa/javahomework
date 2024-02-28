
public class Main {
    private static volatile Fork fork1 = new Fork();
    private static volatile Fork fork2= new Fork();
    private static volatile Fork fork3= new Fork();
    private static volatile Fork fork4= new Fork();
    private static volatile Fork fork5= new Fork();

    public static void main(String[] args) {

        Philosopher philosopher1 = new Philosopher("Sokratis", fork1, fork2);
        Philosopher philosopher2 = new Philosopher("Platon", fork2, fork3);
        Philosopher philosopher3 = new Philosopher("Aristotle",fork3, fork4);
        Philosopher philosopher4 = new Philosopher("Kant", fork4, fork5);
        Philosopher philosopher5 = new Philosopher("Konfuzius", fork5, fork1);
        Thread p1 = new Thread(philosopher1);
        Thread p2 = new Thread(philosopher2);
        Thread p3 = new Thread(philosopher3);
        Thread p4 = new Thread(philosopher4);
        Thread p5 = new Thread(philosopher5);
        p1.start();p2.start();p3.start();p4.start();p5.start();

    }
}