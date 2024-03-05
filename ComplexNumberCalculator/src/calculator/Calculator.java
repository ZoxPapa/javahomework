package calculator;

import calculator.logger.Loggable;

public interface Calculator {

    <T> T sum(T number, T number2);
    <T> T mult(T number, T number2);
    <T> T div(T number, T number2);
}
