public class Calculator {
    public static <T extends Number>  float sum(T t1, T t2){
       return t1.floatValue()+ t2.floatValue();
    };
    public static <T extends Number>  float multiply(T t1, T t2){
        return t1.floatValue()* t2.floatValue();
    }
    public static <T extends Number>  float divide(T t1, T t2) {
        return t1.floatValue() / t2.floatValue();
    };
    public static <T extends Number>  float subtract(T t1, T t2) {
        return t1.floatValue() - t2.floatValue();
    }
}
