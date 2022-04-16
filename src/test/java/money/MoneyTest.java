package money;

import money.Dollar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    void multiplyDollar() {
        Dollar five = new Dollar(5);
        assertThat(five.times(2).equals(new Dollar(10))).isEqualTo(true);
        assertThat(five.times(3).equals(new Dollar(15))).isEqualTo(true);
    }

    @Test
    void multiplyFranc() {
        Franc five = new Franc(5);
        assertThat(five.times(2).equals(new Franc(10))).isEqualTo(true);
        assertThat(five.times(3).equals(new Franc(15))).isEqualTo(true);
    }

    @Test
    void equals() {
        // 삼각 측량
        assertThat(new Dollar(5).equals(new Dollar(5))).isEqualTo(true);
        assertThat(new Dollar(5).equals(new Dollar(6))).isEqualTo(false);
        assertThat(new Franc(5).equals(new Franc(5))).isEqualTo(true);
        assertThat(new Franc(5).equals(new Franc(6))).isEqualTo(false);
        assertThat(new Dollar(5).equals(new Franc(5))).isEqualTo(false);
    }

}