package calculator;

public class ComplexCalculator implements Calculator{
    @Override
    public <T> T sum(T number, T number2) {
        System.out.println("There will be summary between " + number + " " + number2);
        return null;
    }

    @Override
    public <T> T mult(T number, T number2) {
        System.out.println("There will be multiply between " + number + " " + number2);
        return null;
    }

    @Override
    public <T> T div(T number, T number2) {
        System.out.println("There will be divide between " + number + " " + number2);
        return null;
    }
}
