package calculator;

import ComplexNumber.ComplexNumber;
import calculator.logger.ConsoleLogger;
import calculator.logger.Loggable;

public class ComplexCalculator implements Calculator{
    Loggable logger = new ConsoleLogger();
    @Override
    public <T> T sum(T number, T number2) {
        if(!(number instanceof ComplexNumber && number2 instanceof ComplexNumber)) return null;
        int realPart = ((ComplexNumber) number).getFirstPart()+((ComplexNumber) number2).getFirstPart();
        int imaginaryPart = ((ComplexNumber) number).getSecondPart()+ ((ComplexNumber) number2).getSecondPart();
        T result = (T)new ComplexNumber(realPart, imaginaryPart);
        logger.log(number, number2, result, '+');
        return result;
    }

    @Override
    public <T> T mult(T number, T number2) {
        T result = mult(number, number2, true);
        logger.log(number, number2, result, '*');
        return result;
    }

    public <T> T mult(T number, T number2, boolean flag) {
        if(!(number instanceof ComplexNumber && number2 instanceof ComplexNumber)) return null;
        int n1R = ((ComplexNumber) number).getFirstPart();
        int n1I = ((ComplexNumber) number).getSecondPart();
        int n2R = ((ComplexNumber) number2).getFirstPart();
        int n2I = ((ComplexNumber) number2).getSecondPart();
        int realPart = n1R*n2R+n1I*n2I*(-1);
        int imaginaryPart = n1I*n2R+n1R*n2I;
        return (T)new ComplexNumber(realPart, imaginaryPart);
    }

    @Override
    public <T> T div(T number, T number2) {
        if(!(number instanceof ComplexNumber && number2 instanceof ComplexNumber)) return null;
        ComplexNumber conjugateNumber = new ComplexNumber(((ComplexNumber) number2).getFirstPart(),
                ((ComplexNumber) number2).getSecondPart()*(-1));
        ComplexNumber numerator = mult((ComplexNumber) number, conjugateNumber, true);
        ComplexNumber denominator = mult((ComplexNumber) number2, conjugateNumber, true);
        String denominatorShort = denominator.toString().substring(0,denominator.toString().length()-3);
        String fullResult = numerator+ " / "+ denominatorShort;
        logger.log(number, number2, fullResult, '/');
        return null;
    }
}
