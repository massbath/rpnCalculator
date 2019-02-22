package domain;

public class Rpn {

    private final static String patternResolvableExpression = "[0-9] [0-9] [+]";


    public static String calculate(String expression) {

        if (!expression.matches(patternResolvableExpression))
            return expression;

        return compute(expression);
    }

    private static String compute(String expression) {


        int firstOperand = Integer.parseInt(expression.substring(0, 1));
        int secondOperand = Integer.parseInt(expression.substring(2, 3));

        Integer resultatInt = firstOperand + secondOperand;

        return resultatInt.toString();
    }


}
