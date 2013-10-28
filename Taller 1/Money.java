package datastructures;

import java.io.Serializable;

public class Money implements Accumulable<Money>, Comparable<Money>, Serializable {

    private int amount;

    public int getAmount() {
        return amount;
    }
    
    public Money(int initAmount) {
        this.amount = initAmount;
    }
    
    public Money() {
        this(0);
    }

    @Override
    public Money accumulate(Money t1, Money t2) {
        return new Money(t1.getAmount() + t2.getAmount());
    }

    @Override
    public int compareTo(Money t) {
        return this.getAmount() - t.getAmount();
    }
}
