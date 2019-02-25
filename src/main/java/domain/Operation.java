package domain;

import domain.exception.UnknownOperatorException;

import java.util.Optional;

import static domain.Operator.DIVISION;

class Operation {

    private final Integer firstOperand;
    private final Integer secondOperand;
    private final Operator operatorEnum;


    protected Operation(Integer firstOperand, Integer secondOperand, Operator operatorEnum) {
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
        private Integer firstOperand;
        private Integer secondOperand;
        private Operator operatorEnum;

        private Builder() {
        }

        static Builder newBuilder() {
            return new Builder();
        }

        Builder withFirstOperand(Integer val) {
            firstOperand = val;
            return this;
        }

        Builder withSecondOperand(Integer val) {
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
