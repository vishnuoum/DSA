import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FloydWarshall {
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
        floydWarshall(V, edges);
    }

    private static void floydWarshall(int V, int[][] edges) {
        int[][] adj = getAdjMat(V, edges);
        for (int k = 0; k < V; k++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (u != v && v != k && u != k && adj[u][k] != 0 && adj[k][v] != 0
                            && (adj[u][v] == 0 || adj[u][v] > adj[u][k] + adj[k][v])) {
                        adj[u][v] = adj[u][k] + adj[k][v];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(adj));
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
