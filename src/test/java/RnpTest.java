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
    public void name() {

        String resultat = Rpn.calculate("1 1 +");
        assertThat(resultat).isEqualTo("2");

        resultat = Rpn.calculate("2 1 +");
        assertThat(resultat).isEqualTo("3");

        resultat = Rpn.calculate("3 1 +");
        assertThat(resultat).isEqualTo("4");


    }
}
