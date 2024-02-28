import java.util.Random;

public class Philosopher implements Runnable{
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private int timesToEat = 0;


    @Override
    public void run() {
        while (timesToEat < 3) {
            try {
                eat(this.leftFork, this.rightFork);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " already eat 3 times.");
    }

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private synchronized void eat(Fork leftFork, Fork rightFork) throws InterruptedException {
        if (leftFork.isFree && rightFork.isFree) {
            this.leftFork.isFree = false;
            this.rightFork.isFree = false;
            System.out.printf(name + " take forks: %s, %s. \n", this.leftFork.number, this.rightFork.number);
            Thread.sleep(new Random().nextInt(2000));
            timesToEat++;
            System.out.println(name +" finished his "+ timesToEat + " dish.");
            this.leftFork.isFree = true;
            this.rightFork.isFree = true;
        }
    }
}
