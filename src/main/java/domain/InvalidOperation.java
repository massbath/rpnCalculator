package domain;

class InvalidOperation extends Operation {

    InvalidOperation(int firstOperand, int secondOperand, String operator) {
        super(firstOperand, secondOperand, operator);
    }

    @Override
    public boolean isValid() {
        return false;
    }
}
