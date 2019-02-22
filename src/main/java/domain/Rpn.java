package domain;

public class Rpn {

    private final static String patternResolvableExpression = "[0-9] 1 [+]";


    public static String calculate(String expression) {

        if (!expression.matches(patternResolvableExpression))
            return expression;


        Integer resultatInt = Integer.parseInt(expression.substring(0, 1)) + 1;
        return resultatInt.toString();
    }


}
