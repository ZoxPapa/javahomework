package ComplexNumber;

public class ComplexNumber {
    String firstPart;
    String secondPart;
    public ComplexNumber(String firstPart, String secondPart) {
        this.firstPart = firstPart;
        this.secondPart = secondPart;
    }

    @Override
    public String toString() {
        return firstPart+"+"+secondPart;
    }
}
