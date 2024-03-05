package calculator.command;

import calculator.Calculator;

public class DivCommand <T> implements Command{
    T firstNumber;
    T secondNumber;
    Calculator calculator;
    public DivCommand(T firstNumber, T secondNumber, Calculator calculator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.calculator = calculator;
    }
    @Override
    public void execute() {
        calculator.div(firstNumber, secondNumber);
    }
}
