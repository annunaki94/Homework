package workshop2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutator {

    public static <E extends Comparable<E>, T extends List<E>> boolean nextPermutation(T list) {
        //el índice "a" recorre la lista "de derecha a izquierda"
        for (int a = list.size() - 2; a >= 0; --a) {
            //se encuentra la primera pareja consecutiva de elementos en la cual el primero es menor que el segundo
            if (list.get(a).compareTo(list.get(a + 1)) < 0) {
                //el indice "b" recorre la lista "de derecha a izquierda"
                for (int b = list.size() - 1;b>=0; --b) {
                    //A= elemento en la pos a de la lista
                    //B= elemento en la pos b de la lista                    
                    if (list.get(b).compareTo(list.get(a)) > 0) {
                        //Para el primer B mayor que A se intercambian sus posiciones
                        Collections.swap(list, a, b);
                        //Se invierte el orden de todos los elementos de la lista desde la posición a+1 hasta la última posición
                        for (++a, b = list.size() - 1; a < b; ++a, --b) {
                            Collections.swap(list, a, b);
                        }
                        return true;
                    }
                }
            }
        }
        //si el arreglo está organizado en sentido contrario según el método compareTo (no hay siguiente permutación), se retorna falso
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
        l.add("c");
        for (int i = 0; i < 6; i++) {
            for (String s : l) {
                System.out.print(s + " ");
            }
            System.out.println();
            nextPermutation(l);
        }
    }
}
