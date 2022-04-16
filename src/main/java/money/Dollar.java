package money;

public class Dollar {

    int amount;

    public Dollar times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    public Dollar(int amount) {
        this.amount = amount;
    }

    public boolean equals(Dollar dollar) {
        if (this.amount == dollar.amount) {
            return true;
        }
        return false;
    }
}