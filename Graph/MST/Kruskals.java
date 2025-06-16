import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class Kruskals {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no. of vertices");
        int V = Integer.parseInt(in.readLine());
        System.out.println("Enter no. of edges");
        int E = Integer.parseInt(in.readLine());
        int[][] edges = new int[E][3];
        System.out.println("Enter the edges");
        for (int i = 0; i < E; i++) {
            String[] edge = in.readLine().split(" ");
            edges[i] = new int[] { Integer.parseInt(edge[0]), Integer.parseInt(edge[1]), Integer.parseInt(edge[2]) };
        }
        kruskals(V, edges);
    }

    private static void kruskals(int V, int[][] edges) {
        int[][] adjMat = getAdjMat(V, edges);
        int[] parents = new int[V];
        int[] weight = new int[V];
        Arrays.fill(parents, -1);
        for (int k = 0; k < V; k++) {
            int min = Integer.MAX_VALUE;
            int u = -1;
            int a = -1;
            int v = -1;
            int b = -1;
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (i != j && adjMat[i][j] != 0 && adjMat[i][j] < min) {
                        min = adjMat[i][j];
                        a = u = i;
                        b = v = j;
                    }
                }
            }
            u = parent(u, parents);
            v = parent(v, parents);
            if (applyUnion(u, v, parents)) {
                weight[b] = min;
                adjMat[a][b] = adjMat[b][a] = Integer.MAX_VALUE;
            }
        }
        System.out.println("Weights: " + Arrays.toString(weight));
        System.out.println("Parents: " + Arrays.toString(parents));
    }

    private static int parent(int i, int[] parents) {
        if (parents[i] == -1)
            return i;
        parents[i] = parent(parents[i], parents);
        return parents[i];
    }

    private static boolean applyUnion(int u, int v, int[] parents) {
        if (u == v)
            return false;
        parents[v] = u;
        return true;
    }

    private static int[][] getAdjMat(int V, int[][] edges) {
        int[][] adjMat = new int[V][V];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjMat[u][v] = w;
            adjMat[v][u] = w;
        }
        return adjMat;
    }
}