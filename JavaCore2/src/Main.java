import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int [] array = {0, 2,1, 0, 10, 2, 3, 0 ,4, 23};
        int [] array2 = {-1024,-123, 1, 1, 1, 1};

//        System.out.println(countEvens(array));
//        System.out.println(diffMaxMin(array2));
        System.out.println(neighboursZeros(array));
    }

    public static int countEvens(int[] array){
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==0){
                counter+=1;
            }
        }
        return counter;
    }

    public static int diffMaxMin (int[]array){
        int min = array[0];
        int max = array[0];
        for (int i:array) {
            if(i<min){
                min = i;
            } else if (i>max) {
                max = i;
            }
        }
        return (max-min);
    }

    public static boolean neighboursZeros(int[]array){
        boolean flag = false;
        for (int i:array) {
            if(i==0){
                if(flag == true){
                    return true;
                }
            flag = true;
            }
            else {
                flag = false;
            }
        }
        return false;
    }
}