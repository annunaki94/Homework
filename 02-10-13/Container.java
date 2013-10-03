package datastructures;

import java.io.Serializable;

public class Container implements Accumulable<Container>, Comparable<Container>, Serializable {

    private double volume;

    public double getVolume() {
        return volume;
    }

    public Container(double initVolume) {
        this.volume = initVolume;
    }

    public Container() {
        this(0.0);
    }

    @Override
    public Container accumulate(Container t1, Container t2) {
        return new Container(t1.getVolume() + t2.getVolume());
    }

    @Override
    public int compareTo(Container t) {
        return Double.compare(this.getVolume(), t.getVolume());
    }
}
