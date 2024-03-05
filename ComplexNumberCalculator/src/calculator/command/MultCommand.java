package calculator.command;

import calculator.Calculator;

public class MultCommand <T> implements Command{
    T firstNumber;
    T secondNumber;
    Calculator calculator;
    public MultCommand(T firstNumber, T secondNumber, Calculator calculator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.calculator = calculator;
    }
    @Override
    public void execute() {
        calculator.mult(firstNumber, secondNumber);
    }
}
