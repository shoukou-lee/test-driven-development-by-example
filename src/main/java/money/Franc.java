package money;

public class Franc extends Money {

    public Franc times(int multiplier) {
        return new Franc(this.amount * multiplier);
    }

    public Franc(int amount) {
        this.amount = amount;
    }

}