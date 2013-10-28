package preExam;

import java.util.ArrayList;

public class Conjuntos {

    public static void printIndexes(ArrayList<Integer> L, ArrayList<Integer> P) {
        for (Integer i : P) {
            System.out.print(((i < L.size() && i >= 0) ? L.get(i) : "null") + " ");
        }
        System.out.println();
    }

    public static <T> ArrayList<T> getIntersection(ArrayList<T> L1, ArrayList<T> L2) {
        ArrayList<T> response = new ArrayList<>();
        for (T e : L1) {
            if (L2.contains(e)&&!response.contains(e)) {
                response.add(e);
            }
        }
        return response;
    }

    public static <T> ArrayList<T> getUnion(ArrayList<T> L1, ArrayList<T> L2) {
        ArrayList<T> response = new ArrayList<>();
        for (T e : L1) {
            response.add(e);
        }
        for (T e : L2) {
            if (!response.contains(e)) {
                response.add(e);
            }
        }
        return response;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        positions.add(0);
        positions.add(5);
        positions.add(4);
        positions.add(1);
        positions.add(3);
        positions.add(2);
        positions.add(0);
        printIndexes(integers, positions);
        System.out.println("\nIntersección: ");
        ArrayList<Integer> intersection = getIntersection(integers, positions);
        for (Integer i : intersection) {
            System.out.print(i + " ");
        }
        System.out.println("\nUnion: ");
        ArrayList<Integer> union = getUnion(integers, positions);
        for (Integer i : union) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
