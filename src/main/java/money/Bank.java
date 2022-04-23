package money;

import java.util.Hashtable;

public class Bank {

    private Hashtable rates = new Hashtable();

    public Money reduce(Expression src, String to) {
        return src.reduce(this, to);
    }

    public int getRate(String from, String to) {
        if (from.equals(to)) return 1;

        Integer rate = (Integer) rates.get(new Pair(from, to));

        return rate.intValue();
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    private class Pair {
        private String from;
        private String to;

        Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return from.equals(pair.from) && to.equals(pair.to);
        }

        public int hashCode() {
            return 0;
        }
    }
}
