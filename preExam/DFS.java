package preExam;

public class DFS {

    private static boolean[] visited;

    public static void dfsPrinter(int[][] matriz, int node) {
        visited = new boolean[matriz.length];
        for (boolean bool : visited) {
            bool = false;
        }
        visit(matriz, node);
    }

    private static void visit(int[][] matriz, int node) {
        visited[node] = true;
        System.out.println(node);
        for (int i = 0; i < matriz[node].length; i++) {
            if (matriz[node][i] == 1 && !visited[i]) {
                visit(matriz, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrizAdyacencia = {{0,1,0,0,1,0,0,1},
                                    {1,0,1,0,1,0,0,0},
                                    {0,1,0,1,0,0,0,0},
                                    {0,0,1,0,1,1,0,0},
                                    {1,1,0,1,0,0,0,1},
                                    {0,0,0,1,0,0,0,0},
                                    {0,0,0,0,0,0,0,0},
                                    {1,0,0,0,1,0,0,0}};
        dfsPrinter(matrizAdyacencia, 5);
    }
}
