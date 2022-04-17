package money;

public class Dollar extends Money {

    public Money times(int multiplier) {
        return Money.dollar(super.amount * multiplier);
    }

    public Dollar(int amount, String currency) {
        super(amount, currency);
    }

}