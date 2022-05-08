package money;

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
    void equals() {
        // 삼각 측량
        assertThat(Money.dollar(5).equals(Money.dollar(5))).isEqualTo(true);
        assertThat(Money.dollar(5).equals(Money.dollar(6))).isEqualTo(false);
        assertThat(Money.dollar(5).equals(Money.franc(5))).isEqualTo(false);
    }

    @Test
    void currency() {
        assertThat(Money.dollar(1).getCurrency()).isEqualTo("USD");
        assertThat(Money.franc(1).getCurrency()).isEqualTo("CHF");
    }

    @Test
    void simpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertThat(Money.dollar(10)).isEqualTo(reduced);
    }

    @Test
    void plusReturnSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;

        assertThat(sum.augend).isEqualTo(five);
        assertThat(sum.addend).isEqualTo(five);
    }

    @Test
    void reduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");

        assertThat(result).isEqualTo(Money.dollar(7));
    }

    @Test
    void reduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");

        assertThat(result).isEqualTo(Money.dollar(1));
    }

    @Test
    void reduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");

        assertThat(result).isEqualTo(Money.dollar(1));
    }

    @Test
    void identifyRate() {
        assertThat(new Bank().getRate("USD", "USD")).isEqualTo(1);
    }

    @Test
    void mixedAddition() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();

        bank.addRate("CHF", "USD", 2);

        Money ret = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertThat(ret.equals(Money.dollar(10))).isEqualTo(true);
    }
}