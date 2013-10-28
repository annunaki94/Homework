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
        Comparator c = new Comparator<T>() {
            @Override
            public int compare(T t, T t1) {
                return t.compareTo(t1);
            }
        };
        sort(start, end, c);
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
                T t1 = this.get(hi);
                T t2 = this.get(lo);
                this.remove(lo);
                this.add(lo, t1);
                this.remove(hi);
                this.add(hi, t2);
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
            int high = start + r.nextInt(end - start);
            T h = this.get(high);
            T l = this.get(i);
            this.remove(i);
            this.add(i, h);
            this.remove(high);
            this.add(high, l);
        }
    }

    public static <T extends Serializable & Comparable<? super T> & Accumulable<T>> T fold(ArrayLinearListImproved<T> array) {
        if (array.size() > 0) {
            T e = array.get(0);
            for (int i = 1; i < array.size(); i++) {
                e = e.accumulate(e, array.get(i));
            }
            return e;
        }
        return null;
    }

    public static void main(String a[]) {
        System.out.println("Prueba para sort:\nArray original:");
        ArrayLinearListImproved<Integer> arrayEntrada = new ArrayLinearListImproved<Integer>(6);
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

        arrayEntrada.sort(0, arrayEntrada.size() - 1);
        System.out.println("Array ordendo:");
        for (int i = 0; i < arrayEntrada.size(); i++) {
            System.out.print(arrayEntrada.get(i) + "  ");
        }
        System.out.println("\n\nPrueba para fold y accumulate\nArray original de Money:");

        ArrayLinearListImproved<Money> array1 = new ArrayLinearListImproved<Money>(3);
        array1.add(0, new Money(1000));
        array1.add(1, new Money(3500));
        array1.add(2, new Money(10000));

        for (int i = 0; i < array1.size(); i++) {
            System.out.print(array1.get(i).getAmount() + "-");
        }
        System.out.println();

        Money totalMoney = ArrayLinearListImproved.fold(array1);
        System.out.println("Resultado de fold: " + totalMoney.getAmount());

        System.out.println("\n\nArray original de AccumulableString:");

        ArrayLinearListImproved<AccumulableString> array2 = new ArrayLinearListImproved<AccumulableString>(3);
        array2.add(0, new AccumulableString("Hello"));
        array2.add(1, new AccumulableString(" Universidad"));
        array2.add(2, new AccumulableString(" Nacional"));

        for (int i = 0; i < array2.size(); i++) {
            System.out.print(array2.get(i).getStr() + "-");
        }
        System.out.println();

        AccumulableString totalString = ArrayLinearListImproved.fold(array2);
        System.out.println("Resultado de fold: " + totalString.getStr());

        System.out.println("\n\nArray original de Container:");

        ArrayLinearListImproved<Container> array3 = new ArrayLinearListImproved<Container>(3);
        array3.add(0, new Container(10.8));
        array3.add(1, new Container(4.3));
        array3.add(2, new Container(5.1));

        for (int i = 0; i < array3.size(); i++) {
            System.out.print(array3.get(i).getVolume() + "-");
        }
        System.out.println();

        Container totalVolume = ArrayLinearListImproved.fold(array3);
        System.out.printf("Resultado de fold: %.3f\n" , totalVolume.getVolume());

    }
}
