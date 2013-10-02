package datastructures;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Random;

public class ArrayLinearListImproved<T extends Serializable & Comparable<? super T>> extends ArrayLinearList<T> {

    public ArrayLinearListImproved(int initialCapacity) {
        super(initialCapacity);
    }

    public ArrayLinearListImproved() {
        this(10);
    }

    public void sort(int start, int end) {
        Comparator c= new Comparator<T>(){
            @Override
            public int compare(T t, T t1) {
                return t.compareTo(t1);
            }
        };
        sort(start,end,c);
    }

    public void sort(int start, int end, Comparator<T> c) {
        int lo = start;
        int hi = end;
        if (lo >= end) {
            return;
        }
        T mid = this.get((lo + hi) / 2);

        while (lo < hi) {
            while (lo < hi && c.compare(this.get(lo), mid) < 0) {
                lo++;
            }
            while (lo < hi && c.compare(this.get(hi), mid) > 0) {
                hi--;
            }
            if (lo < hi) {
                T t = this.remove(hi);
                this.add(hi, this.get(lo));
                this.remove(lo);
                this.add(lo, t);
            }
        }
        if (hi < lo) {
            int T = hi;
            hi = lo;
            lo = T;
        }
        sort(start, lo, c);
        sort(lo == start ? lo + 1 : lo, end, c);
    }

    public void randomize(int start, int end) {
        Random r = new Random();
        for (int i = start; i <= end; i++) {
            int high = start+r.nextInt(end-start);
            T h = this.get(high);
            T l = this.get(i);
            this.remove(i);
            this.add(i, h);
            this.remove(high);
            this.add(high, l);
        }        
    }
    
    
    public static void main(String a[]) {
        ArrayLinearListImproved<Integer> arrayEntrada = new ArrayLinearListImproved(6);
        arrayEntrada.add(0, 4);
        arrayEntrada.add(1, 48);
        arrayEntrada.add(2, 5);
        arrayEntrada.add(3, 3);
        arrayEntrada.add(4, 50);
        arrayEntrada.add(5, 30);

        for (int i = 0; i < arrayEntrada.size(); i++) {
            System.out.print(arrayEntrada.get(i) + "  ");
        }
        System.out.println();

        arrayEntrada.sort(1, arrayEntrada.size()-1);

        for (int i = 0; i < arrayEntrada.size(); i++) {
            System.out.print(arrayEntrada.get(i) + "  ");
        }
        System.out.println();
    }
}
