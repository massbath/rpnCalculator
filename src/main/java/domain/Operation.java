package domain;

import domain.exception.UnknownOperatorException;

import java.util.Optional;

import static domain.Operator.DIVISION;

class Operation {

    private final int firstOperand;
    private final int secondOperand;
    private final Operator operatorEnum;


    Operation(int firstOperand, int secondOperand, Operator operatorEnum) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operatorEnum = operatorEnum;
    }


    int makeOperation() {
        return operatorEnum.operate.apply(firstOperand, secondOperand);
    }

    public boolean isValid() {
        return true;
    }


    static final class Builder {
        private int firstOperand;
        private int secondOperand;
        private Operator operatorEnum;

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
            Optional<Operator> operator = Operator.fromValue(val);

            if (!operator.isPresent())
                throw new UnknownOperatorException("Unknown operator " + val + " you should add this operator in enum Operator");

            operatorEnum = operator.get();

            return this;

        }

        Operation build() {
            if (operatorEnum == DIVISION && secondOperand == 0) {
                return new InvalidOperation(firstOperand, secondOperand, operatorEnum);
            }

            return new Operation(firstOperand, secondOperand, operatorEnum);
        }
    }
}
