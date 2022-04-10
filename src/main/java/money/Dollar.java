package money;

public class Dollar {

    int amount;

    public Dollar times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    public Dollar(int amount) {
        this.amount = amount;
    }
}