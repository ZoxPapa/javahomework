import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float result;
        while (true) {
            try {
                result = Float.parseFloat(inputFloat());
                System.out.println(result);
                System.exit(0);
            } catch (NumberFormatException e) {
                System.out.println("Input float please");
                ;
            }
        }
    }

        static String inputFloat () {
            Scanner sc = new Scanner(System.in);
            String number = sc.nextLine();
            return number;
        }
    }