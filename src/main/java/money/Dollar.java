package money;

public class Dollar {

    private int amount;

    public Dollar times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    public Dollar(int amount) {
        this.amount = amount;
    }

    public boolean equals(Dollar dollar) {
        return this.amount == dollar.amount;
    }
}