package domain;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operator {

    ADDITION("+", (firstOperand, secondOperand) -> firstOperand + secondOperand),
    SUBTRACTION("-", (firstOperand, secondOperand) -> firstOperand - secondOperand),
    DIVISION("/", (firstOperand, secondOperand) -> firstOperand / secondOperand),
    MULTIPLICATION("*", (firstOperand, secondOperand) -> firstOperand * secondOperand);


    private final String sign;
    public final BiFunction<Integer, Integer, Integer> operate;

    Operator(String sign, BiFunction<Integer, Integer, Integer> operate) {
        this.sign = sign;
        this.operate = operate;
    }

    public static Optional<Operator> fromValue(String sign) {
        return Stream.of(Operator.values())
                .filter((operator) -> operator.sign.equals(sign))
                .findFirst();
    }
}
