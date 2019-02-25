package domain;

import static domain.Operation.Builder.newBuilder;

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

        Operation operation = newBuilder().withFirstOperand(firstOperand).withSecondOperand(secondOperand).withOperator(operator).build();
        int resultatInt = operation.makeOperation();

        return Integer.toString(resultatInt);

    }


}
