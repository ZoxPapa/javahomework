import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        numberFormatException();
    }

    public static int arrayOutOfBoundsException() {
        int[] arr = new int[10];
        return arr[12];
    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        int a = 10/0;
    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        int a = Integer.parseInt("9 ");
        int b = 1;
        int c = a/b;
    }
}