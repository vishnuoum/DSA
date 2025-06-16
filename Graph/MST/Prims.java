import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Prims {
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
        prims(V, edges);
    }

    private static void prims(int V, int[][] edges) {
        List<List<List<Integer>>> adjList = getAdjList(V, edges);
        boolean[] visited = new boolean[V];
        int[] weight = new int[V];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[0] = 0;
        int[] parent = new int[V];
        parent[0] = -1;
        for (int i = 0; i < V - 1; i++) {
            int u = minUnvisited(V, weight, visited);
            visited[u] = true;
            for (List<Integer> neighbour : adjList.get(u)) {
                int v = neighbour.get(0);
                int w = neighbour.get(1);
                if (u != v && w < weight[v]) {
                    weight[v] = w;
                    parent[v] = u;
                }
            }
        }
        System.out.println("Weights: " + Arrays.toString(weight));
        System.out.println("Parents: " + Arrays.toString(parent));
    }

    private static int minUnvisited(int V, int[] weight, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < V; i++) {
            if (min > weight[i] && !visited[i]) {
                min = weight[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static List<List<List<Integer>>> getAdjList(int V, int[][] edges) {
        List<List<List<Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(List.of(edge[1], edge[2]));
            adjList.get(edge[1]).add(List.of(edge[0], edge[2]));
        }
        return adjList;
    }
}