package datastructures;

public interface Accumulable<T> {

    T accumulate(T t1, T t2);
}