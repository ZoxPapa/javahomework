package calculator.logger;

public class ConsoleLogger implements Loggable{

    @Override
    public <T> void log(T firstNumber, T secondNumber, T result, char action) {
        System.out.printf("%s %c %s = %s \n", firstNumber, action, secondNumber, result);
    }
}
