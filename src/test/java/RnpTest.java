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
    @Parameters({
            "2 2 + 2 -,2",
            "2 2 + 2 - 3 +,5",
            "2 2 + 2 - 3 + 5 /,1",
            "2 2 + 2 - 3 + 5 / 189 +,190",
            "2 2 + 2 - 3 + 5 / 189 + 0 /,190 0 /",
    })
    public void a_expression_with_multiple_operation_should_give_the_result_of_all_operation(String expression, String resultatExpected) {
        String resultat = Rpn.calculate(expression);
        assertThat(resultat).isEqualTo(resultatExpected);
    }
}
