package money;

public class Dollar extends Money {

    public Money times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    public Dollar(int amount) {
        this.amount = amount;
    }

}