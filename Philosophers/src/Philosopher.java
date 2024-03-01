import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable{
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private int timesToEat = 0;


    @Override
    public void run() {
        while (timesToEat < 3) {
            try {
                synchEat();
                think();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " already eat 3 times.");
    }

    private void think() throws InterruptedException {
        Thread.sleep(100);
    }

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void eat() throws InterruptedException {
        if (leftFork.isFree && rightFork.isFree) {
            this.leftFork.isFree = false;
            this.rightFork.isFree = false;
            System.out.printf(name + " take forks: %s, %s. \n", this.leftFork.number, this.rightFork.number);
            Thread.sleep(new Random().nextInt(100));
            timesToEat++;
            System.out.println(name +" finished his "+ timesToEat + " dish.");
            this.leftFork.isFree = true;
            this.rightFork.isFree = true;
        }
    }

    private synchronized void synchEat() throws InterruptedException {
        if(leftFork.number<rightFork.number){
            synchronized (leftFork){
                synchronized (rightFork){
                    eat();
                }
            }
        }else {
            synchronized (rightFork){
                synchronized (leftFork){
                    eat();
                }
            }
        }
    }
}
