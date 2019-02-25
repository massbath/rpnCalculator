package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static domain.Operation.Builder.newBuilder;

public class Rpn {

    private final static String patternResolvableExpression = "([0-9]+ [0-9]+ [+-/])";
    private static final String SEPARATOR = " ";
    private static final int FIRST_OPERAND_POSITION = 0;
    private static final int SECOND_OPERAND_POSITION = 1;
    private static final int OPERATOR_POSITION = 2;
    private static Pattern pattern = Pattern.compile(patternResolvableExpression);


    public static String calculate(String expression) {
        Matcher matcher = pattern.matcher(expression);
        String resultat = expression;

        while (matcher.find()) {
            String resultatSubOperation = calculateSimpleExpression(matcher.group());
            resultat = matcher.replaceFirst(resultatSubOperation);

            if (resultatSubOperation.matches(patternResolvableExpression)) {
                return resultat;
            }

            matcher.reset(resultat);
        }


        return resultat;
    }

    public static String calculateSimpleExpression(String expression) {

        if (isAValidExpression(expression))
            return expression;

        return compute(expression);
    }

    private static boolean isAValidExpression(String expression) {
        return !expression.matches(patternResolvableExpression);
    }

    private static String compute(String expression) {

        Operation operation = extractOperation(expression);

        if (!operation.isValid()) {
            return expression;
        }

        int resultatInt = operation.makeOperation();
        return Integer.toString(resultatInt);
    }

    private static Operation extractOperation(String expression) {
        String[] partsOfExpression = expression.split(SEPARATOR);

        int firstOperand = Integer.parseInt(partsOfExpression[FIRST_OPERAND_POSITION]);
        int secondOperand = Integer.parseInt(partsOfExpression[SECOND_OPERAND_POSITION]);
        String operator = partsOfExpression[OPERATOR_POSITION];

        return newBuilder()
                .withFirstOperand(firstOperand)
                .withSecondOperand(secondOperand)
                .withOperator(operator)
                .build();
    }



}
