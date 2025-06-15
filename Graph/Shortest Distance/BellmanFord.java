import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
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
        System.out.println("Enter the starting vertex");
        int start = Integer.parseInt(in.readLine());
        bellman(start, V, edges);
    }

    private static void bellman(int start, int V, int[][] edges) {
        List<List<List<Integer>>> adjList = getAdjList(V, edges);
        int[] distance = new int[V];
        int[] parent = new int[V];
        parent[start] = -1;
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        for (int i = 0; i < V; i++) {
            for (int u = 0; u < V - 1; u++) {
                for (List<Integer> neighbour : adjList.get(u)) {
                    int v = neighbour.get(0);
                    int w = neighbour.get(1);
                    if (u != v && distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w) {
                        if (i == V - 1) {
                            System.out.println("Negative cycle");
                            return;
                        }
                        distance[v] = distance[u] + w;
                        parent[v] = u;
                    }
                }
            }
        }
        System.out.println("Distance: " + Arrays.toString(distance));
        System.out.println("Parent: " + Arrays.toString(parent));
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
