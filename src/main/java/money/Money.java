package money;

public class Money {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, currency);
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public boolean equals(Object o) {
        Money money = (Money) o;
        if (this.getCurrency().equals(money.getCurrency())) {
            return this.amount == money.amount;
        }
        return false;
    }

    public String getCurrency() {
        return this.currency;
    }

}
