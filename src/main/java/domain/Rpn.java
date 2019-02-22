package domain;

public class Rpn {

    private final static String patternResolvableExpression = "[0-9]+ [0-9]+ [+]";


    public static String calculate(String expression) {

        if (!expression.matches(patternResolvableExpression))
            return expression;

        return compute(expression);
    }

    private static String compute(String expression) {


        String[] partsOfExpression = expression.split(" ");

        int firstOperand = Integer.parseInt(partsOfExpression[0]);
        int secondOperand = Integer.parseInt(partsOfExpression[1]);

        Integer resultatInt = firstOperand + secondOperand;

        return resultatInt.toString();
    }


}
