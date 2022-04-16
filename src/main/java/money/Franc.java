package money;

public class Franc {

    private int amount;

    public Franc times(int multiplier) {
        return new Franc(this.amount * multiplier);
    }

    public Franc(int amount) {
        this.amount = amount;
    }

    public boolean equals(Franc franc) {
        return this.amount == franc.amount;
    }
}