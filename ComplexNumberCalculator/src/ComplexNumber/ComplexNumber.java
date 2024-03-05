package ComplexNumber;

public class ComplexNumber {
    int firstPart;
    int secondPart;
    public ComplexNumber(int firstPart, int secondPart) {
        this.firstPart = firstPart;
        this.secondPart = secondPart;
    }

    public int getFirstPart() {
        return firstPart;
    }

    public int getSecondPart() {
        return secondPart;
    }

    @Override
    public String toString() {
        return secondPart>=0? firstPart+"+"+secondPart+"i" : ""+firstPart+secondPart+"i";
    }
}
