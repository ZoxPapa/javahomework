public class Main2 {
    public static void main(String[] args) {
        try {
            int[] intArray = {1,2,3,4,1,}; //{1,2,3,4,2,1,2,3,4,12,1,2,3}
            int d = 0; //любое число, отличное от нуля
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Out of bounds exception. Array is too short. \n" +e);
        }

    }
}
