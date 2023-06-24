import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        
        System.out.println(triangle_digit());
    }
    static int triangle_digit (){
        System.out.println("Input index of number in a row of triangle numbers: ");
        Scanner my_Scanner = new Scanner(System.in);
        String digit = my_Scanner.nextLine();
        int number = Integer.parseInt(digit);
        int result = number*(number+1)/2;
        return result;
    }
    public static int input_digit(){
        System.out.println("Input digit: ");
        Scanner my_Scanner = new Scanner(System.in);
        String digit = my_Scanner.nextLine();
        int number = Integer.parseInt(digit);
        return number;
    }
}
