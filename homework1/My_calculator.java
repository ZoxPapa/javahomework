import java.util.Scanner;

public class My_calculator {
    public static void main(String[] args) {
        System.out.println("What act do you want to do? (+ or - or * or /)");
        char act = input_act();
        System.out.println("First integer");
        int first = input_digit();
        System.out.println("Second integer");
        int second = input_digit();
        System.out.println(calculating(act, first, second));
    }

    static int input_digit(){
        System.out.println("Input number: ");
        Scanner my_Scanner = new Scanner(System.in);
        String digit = my_Scanner.nextLine();
        int number = Integer.parseInt(digit);
        return number;
    }

    static char input_act(){
        System.out.println("Input act: ");
        Scanner my_Scanner = new Scanner(System.in);
        char act = my_Scanner.next().charAt(0);
        return act;
    }

    static float calculating (char act, int first_num, int second_num){
        float result = 0;
        if(act == '+'){
            result = first_num + second_num;  
        }
        else if(act == '-'){
            result = first_num - second_num;
        }
        else if(act == '*'){
            result = first_num * second_num;
        }
        else if(act == '/'){
            result = first_num / second_num;
        }
        else{System.exit(0);}
        return result;
    }
    
}
