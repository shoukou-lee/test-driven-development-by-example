package money;

public abstract class Money {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    abstract Money times(int multiplier);

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public boolean equals(Object o) {
        Money money = (Money) o;
        if (getClass().equals(o.getClass())) {
            return this.amount == money.amount;
        }
        return false;
    }

    public String currency() {
        return this.currency;
    }

}
