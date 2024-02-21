public class Main {
    public static void main(String[] args) {
//        Calculator calculator = new Calculator();
//        System.out.println(Calculator.sum(0.212d, 0.7f));
//        System.out.println(Calculator.multiply(0.212d, 0.7f));
//        System.out.println(Calculator.divide(0.212d, 3));
//        System.out.println(Calculator.subtract(0.212d, 0.7f));

//        Integer[]arr = {1, 2, 3, 4};
//        Number[]arr2 = {1f, 2, 3, 4};
//        System.out.println(compareArrays(arr, arr2));

        Pair pair = new Pair(1f, 1234d);
        System.out.println(pair);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
    public static <T1, T2> boolean compareArrays(T1[]arr, T2[]arr2){
        if(arr.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getClass()!= arr2[i].getClass()){
                return false;
            }
        }
        return true;
    };
}