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
    public void simple_digit_should_give_simple_digit(String simpleDigit) {
        String resultat = Rpn.calculate(simpleDigit);

        assertThat(resultat).isEqualTo(simpleDigit);
    }


}
