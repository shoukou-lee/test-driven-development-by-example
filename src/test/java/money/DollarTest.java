package money;

import money.Dollar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    void multiply() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertThat(product.amount).isEqualTo(10);

        product = five.times(3);
        assertThat(product.amount).isEqualTo(15);
    }

    @Test
    void equals() {
        // 삼각 측량
        assertThat(new Dollar(5).equals(new Dollar(5))).isEqualTo(true);
        assertThat(new Dollar(5).equals(new Dollar(6))).isEqualTo(false);
    }

}