package datastructures;

import java.io.Serializable;

public class AccumulableString implements Accumulable<AccumulableString>, Comparable<AccumulableString>, Serializable {

    private String str;

    public String getStr() {
        return str;
    }

    public AccumulableString(String initialValue) {
        this.str = initialValue;
    }

    public AccumulableString() {
        this("");
    }

    public AccumulableString accumulate(AccumulableString t1, AccumulableString t2) {
        return (new AccumulableString(t1.getStr() + t2.getStr()));
    }

    @Override
    public int compareTo(AccumulableString o) {
        return this.getStr().compareTo(o.getStr());
    }
}
