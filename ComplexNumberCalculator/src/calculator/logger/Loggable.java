package calculator.logger;

public interface Loggable {
    <T> void log(T firstNumber, T secondNumber, T result, char action);
}
