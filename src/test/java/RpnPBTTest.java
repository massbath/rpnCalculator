import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import domain.Rpn;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class RpnPBTTest {

    @Property
    public void given_2_random_numbers_and_plus_operator_should_give_the_sum_of_both(Integer firstOperand, Integer secondOperand) {
        String expression = firstOperand + " " + secondOperand + " +";
        String resultatExpected = String.valueOf(firstOperand + secondOperand);

        String resultat = Rpn.calculate(expression);

        Assertions.assertThat(resultat).isEqualTo(resultatExpected);
    }
}
