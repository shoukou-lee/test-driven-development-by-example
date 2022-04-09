package money;

public class Dollar {

    int amount;

    public void times(int multiplier) {
        this.amount *= multiplier;
    }

    public Dollar(int amount) {
        this.amount = amount;
    }
}