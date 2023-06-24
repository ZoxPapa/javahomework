public class Homework3 {
    public static void main(String[] args) {
        String result = find_simple_numbers(1000);
        System.out.println(result);
    }

    static String find_simple_numbers(int max_number){
        String result = "";
        int counter = 0;
        for (int j = 1; j <= max_number; j++){
            counter = 0;
             for (int i = 1; i <= max_number/2; i++) {
                if (j%i == 0){counter+=1;}
                }
                if(counter <3){result+= Integer.toString(j)+" ";
                }
            }
        return result;
    }
}
