package domain;

class InvalidOperation extends Operation {

    protected InvalidOperation(int firstOperand, int secondOperand, Operator operatorEnum) {
        super(firstOperand, secondOperand, operatorEnum);
    }

    @Override
    public boolean isValid() {
        return false;
    }
}
