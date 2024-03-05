package ComplexNumber.factory;

import ComplexNumber.ComplexNumber;

import java.util.Random;

public class ComplexFactory implements ComplexNumberFactory {
    @Override
    public ComplexNumber makeNewNumber() {
        //TODO: need to add random negative numbers
        Random random = new Random();
        String firstPart = Integer.toString(random.nextInt(100));
        String secondPart = Integer.toString(random.nextInt(100))+"i";
        return new ComplexNumber(firstPart, secondPart);
    }
}
