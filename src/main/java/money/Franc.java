package money;

public class Franc extends Money {

    public Money times(int multiplier) {
        return Money.franc(this.amount * multiplier);
    }

    public Franc(int amount, String currency) {
        super(amount, currency);
    }

}