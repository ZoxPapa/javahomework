import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) throws Exception {
        String result = inputSomething();
        if(result.isEmpty()){
            Exception lazyMan = new Exception("You must input something. Lazy man.");
            throw lazyMan;
        }else{
            System.out.println("Good boy.");
        }

    }

    static String inputSomething () {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        return number;
    }
}
