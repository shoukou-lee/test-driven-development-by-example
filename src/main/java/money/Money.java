package money;

public abstract class Money {

    protected int amount;

    abstract Money times(int multiplier);

    public static Money dollar(int amount) {
        return new Dollar(amount);
    }

    public static Money franc(int amount) {
        return new Franc(amount);
    }

    public boolean equals(Object o) {
        Money money = (Money) o;
        if (getClass().equals(o.getClass())) {
            return this.amount == money.amount;
        }
        return false;
    }

}
