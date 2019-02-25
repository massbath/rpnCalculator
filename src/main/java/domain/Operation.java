package domain;

class Operation {

    private final int firstOperand;
    private final int secondOperand;
    private final String operator;

    protected Operation(int firstOperand, int secondOperand, String operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }


    int makeOperation() {
        if (operator.equals("+")) {
            return firstOperand + secondOperand;
        }

        if (operator.equals("-"))
            return firstOperand - secondOperand;

        return firstOperand / secondOperand;
    }

    public boolean isValid() {
        return true;
    }


    public static final class Builder {
        private int firstOperand;
        private int secondOperand;
        private String operator;

        private Builder() {
        }

        static Builder newBuilder() {
            return new Builder();
        }

        Builder withFirstOperand(int val) {
            firstOperand = val;
            return this;
        }

        Builder withSecondOperand(int val) {
            secondOperand = val;
            return this;
        }

        Builder withOperator(String val) {
            operator = val;
            return this;
        }

        Operation build() {
            if (operator.equals("/") && secondOperand == 0) {
                return new InvalidOperation(firstOperand, secondOperand, operator);
            }

            return new Operation(firstOperand, secondOperand, operator);
        }
    }
}
