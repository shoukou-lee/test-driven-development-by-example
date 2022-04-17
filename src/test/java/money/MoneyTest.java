package money;

import money.Dollar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    void multiplyDollar() {
        Money five = Money.dollar(5);
        assertThat(five.times(2).equals(Money.dollar(10))).isEqualTo(true);
        assertThat(five.times(3).equals(Money.dollar(15))).isEqualTo(true);
    }

    @Test
    void multiplyFranc() {
        Money five = Money.franc(5);
        assertThat(five.times(2).equals(Money.franc(10))).isEqualTo(true);
        assertThat(five.times(3).equals(Money.franc(15))).isEqualTo(true);
    }

    @Test
    void equals() {
        // 삼각 측량
        assertThat(Money.dollar(5).equals(Money.dollar(5))).isEqualTo(true);
        assertThat(Money.dollar(5).equals(Money.dollar(6))).isEqualTo(false);
        assertThat(Money.franc(5).equals(Money.franc(5))).isEqualTo(true);
        assertThat(Money.franc(5).equals(Money.franc(6))).isEqualTo(false);
        assertThat(Money.dollar(5).equals(Money.franc(5))).isEqualTo(false);
    }

    @Test
    void currency() {
        assertThat(Money.dollar(1).currency()).isEqualTo("USD");
        assertThat(Money.franc(1).currency()).isEqualTo("CHF");
    }

}