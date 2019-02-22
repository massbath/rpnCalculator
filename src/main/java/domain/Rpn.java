package domain;

public class Rpn {

    private final static String patternResolvableExpression = "[0-9]+ [0-9]+ [+-/]";


    public static String calculate(String expression) {

        if (!expression.matches(patternResolvableExpression))
            return expression;

        return compute(expression);
    }

    private static String compute(String expression) {


        String[] partsOfExpression = expression.split(" ");

        int firstOperand = Integer.parseInt(partsOfExpression[0]);
        int secondOperand = Integer.parseInt(partsOfExpression[1]);
        String operator = partsOfExpression[2];

        Integer resultatInt = makeOperation(firstOperand, secondOperand, operator);
        return resultatInt.toString();

    }

    private static int makeOperation(int firstOperand, int secondOperand, String operator) {
        if (operator.equals("+")) {
            return firstOperand + secondOperand;
        }


        if (operator.equals("-"))
            return firstOperand - secondOperand;

        return firstOperand / secondOperand;
    }


}
