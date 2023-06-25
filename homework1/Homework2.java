import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        System.out.println("I can find for you factorials, so");
        int number = input_digit();
        System.out.println(factorial(number));
    }
    static int factorial(int number){
        while (number > 0){
            return number*factorial(number-1);
        }
        return 1;
    }
    static int input_digit(){
        System.out.println("Input number: ");
        Scanner my_Scanner = new Scanner(System.in);
        String digit = my_Scanner.nextLine();
        int number = Integer.parseInt(digit);
        return number;
    }
}
