package workshop2;

import java.util.Comparator;

public interface Searchable<T> {

    public Comparator<T> getSearchingComparator(int searchParameter);
    //searchParameter indicará al método qué Comparator deberá retornar. La implementación podrá o no utilizar el valor del argumento.
}
