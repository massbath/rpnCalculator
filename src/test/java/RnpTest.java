import domain.Rpn;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(JUnitParamsRunner.class)
public class RnpTest {

    @Test
    @Parameters({"1", "2", "B"})
    public void a_expression_with_simple_digit_should_give_simple_digit(String simpleDigit) {
        String resultat = Rpn.calculate(simpleDigit);

        assertThat(resultat).isEqualTo(simpleDigit);
    }

    @Test
    @Parameters({"1 2", "3 4"})
    public void a_expression_with_simple_number_with_whitespace_should_give_the_identical_output(String expression) {
        String resultat = Rpn.calculate(expression);
        assertThat(resultat).isEqualTo(expression);
    }

    @Test
    @Parameters({"1 1 +,2", "2 1 +,3", "3 1 +,4", "1 3 +,4", "1 6 +,7", "10 10 +,20"})
    public void a_expression_with_simple_numbers_and_plus_operator_should_give_the_sum_of_both(String expression, String resultatExpected) {

        String resultat = Rpn.calculate(expression);
        assertThat(resultat).isEqualTo(resultatExpected);

    }
}
