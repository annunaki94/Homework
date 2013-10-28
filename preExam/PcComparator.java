package preExam;

import java.util.Collections;
import java.util.Comparator;

public class PcComparator<T extends Computer> implements Comparator<T> {

    @Override
    public int compare(Computer t, Computer t1) {
        return t.getRam() - t1.getRam();
    }

    public static void main(String[] args) {
        LinearList<? super Laptop> laptops = new LinearList<>();
        //adición de elementos a laptops
        Collections.sort(laptops, new PcComparator());        
    }
}
