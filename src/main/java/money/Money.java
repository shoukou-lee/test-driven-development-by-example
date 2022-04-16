package money;

public class Money {

    protected int amount;

    public boolean equals(Object o) {
        Money money = (Money) o;
        if (getClass().equals(o.getClass())) {
            return this.amount == money.amount;
        }
        return false;
    }

}
