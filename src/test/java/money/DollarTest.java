package money;

import money.Dollar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    void multiply() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertThat(five.amount).isEqualTo(10);
    }

}