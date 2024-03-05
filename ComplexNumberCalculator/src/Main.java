import ComplexNumber.ComplexNumber;
import ComplexNumber.factory.ComplexFactory;
import calculator.Calculator;
import calculator.ComplexCalculator;
import calculator.command.Command;
import calculator.command.DivCommand;
import calculator.command.MultCommand;
import calculator.command.SumCommand;

public class Main {
    public static void main(String[] args) {
        ComplexFactory factory = new ComplexFactory();
        ComplexNumber n1 = factory.makeNewNumber();
        ComplexNumber n2 = factory.makeNewNumber();
        Calculator calculator = new ComplexCalculator();
        Command sumCommand = new SumCommand<>(n1, n2, calculator);
        Command divCommand = new DivCommand<>(n1, n2, calculator);
        Command multCommand = new MultCommand<>(n1, n2, calculator);

        sumCommand.execute();
        multCommand.execute();
        divCommand.execute();
    }
}