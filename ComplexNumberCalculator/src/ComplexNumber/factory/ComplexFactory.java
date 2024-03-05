package ComplexNumber.factory;

import ComplexNumber.ComplexNumber;

import java.util.Random;

public class ComplexFactory implements ComplexNumberFactory {
    @Override
    public ComplexNumber makeNewNumber() {
        //TODO: need to add random negative numbers
        Random random = new Random();
        int firstPart = random.nextInt(-100, 100);
        int secondPart = random.nextInt(-100, 100);
        return new ComplexNumber(firstPart, secondPart);
    }
}
