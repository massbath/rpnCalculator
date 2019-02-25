import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import domain.Rpn;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class RpnPBTTest {

    @Property
    public void a_expression_with_simple_digit_should_give_simple_digit(String randomString) {
        String resultat = Rpn.calculate(randomString);

        assertThat(resultat).isEqualTo(randomString);
    }

    @Property
    public void a_expression_with_simple_number_with_whitespace_should_give_the_identical_output(Integer firstNumber, Integer secondNumber) {
        final String expression = firstNumber + " " + secondNumber;
        String resultat = Rpn.calculate(expression);
        assertThat(resultat).isEqualTo(expression);
    }

    @Property
    public void given_2_random_numbers_and_plus_operator_should_give_the_sum_of_both(Integer firstOperand, Integer secondOperand) {
        String expression = makeExpression(firstOperand, secondOperand, "+");
        String resultatExpected = String.valueOf(firstOperand + secondOperand);

        String resultat = Rpn.calculate(expression);

        assertThat(resultat).isEqualTo(resultatExpected);
    }

    @Property
    public void given_2_random_numbers_and_minus_operator_should_give_the_subtract_of_first_operand_by_second_operand(Integer firstOperand, Integer secondOperand) {
        String expression = makeExpression(firstOperand, secondOperand, "-");
        String resultatExpected = String.valueOf(firstOperand - secondOperand);

        String resultat = Rpn.calculate(expression);

        assertThat(resultat).isEqualTo(resultatExpected);
    }

    @Property
    public void given_2_random_numbers_and_multiply_operator_should_give_the_multiplication_of_both(Integer firstOperand, Integer secondOperand) {
        String expression = makeExpression(firstOperand, secondOperand, "*");
        String resultatExpected = String.valueOf(firstOperand * secondOperand);

        String resultat = Rpn.calculate(expression);

        assertThat(resultat).isEqualTo(resultatExpected);
    }

    @Property
    public void given_2_random_numbers_and_division_operator_should_give_the_division_of_first_operand_by_second_operand(Integer firstOperand, @InRange(minInt = 1) Integer secondOperand) {
        String expression = makeExpression(firstOperand, secondOperand, "/");
        String resultatExpected = String.valueOf(firstOperand / secondOperand);

        String resultat = Rpn.calculate(expression);

        assertThat(resultat).isEqualTo(resultatExpected);
    }

    @Property
    public void given_1_random_number_a_null_number_and_division_operator_should_give_the_division_of_first_operand_by_second_operand(Integer firstOperand) {
        String expression = makeExpression(firstOperand, 0, "/");
        String resultatExpected = firstOperand + " 0 /";

        String resultat = Rpn.calculate(expression);

        assertThat(resultat).isEqualTo(resultatExpected);
    }

    private String makeExpression(Integer firstOperand, Integer secondOperand, String operator) {
        return firstOperand + " " + secondOperand + " " + operator;
    }


}
