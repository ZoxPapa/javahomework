package calculator.command;

import calculator.Calculator;

public class SumCommand <T> implements Command{
    T firstNumber;
    T secondNumber;
    Calculator calculator;
    public SumCommand(T firstNumber, T secondNumber, Calculator calculator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        calculator.sum(firstNumber, secondNumber);
    }
}
