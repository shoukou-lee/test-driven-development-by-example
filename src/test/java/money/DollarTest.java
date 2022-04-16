package money;

import money.Dollar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    void multiply() {
        Dollar five = new Dollar(5);
        assertThat(five.times(2).equals(new Dollar(10))).isEqualTo(true);
        assertThat(five.times(3).equals(new Dollar(15))).isEqualTo(true);
    }

    @Test
    void equals() {
        // 삼각 측량
        assertThat(new Dollar(5).equals(new Dollar(5))).isEqualTo(true);
        assertThat(new Dollar(5).equals(new Dollar(6))).isEqualTo(false);
    }

}