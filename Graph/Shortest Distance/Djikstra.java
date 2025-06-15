import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Djikstra {
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
        djikstra(start, V, edges);
    }

    private static void djikstra(int start, int V, int[][] edges) {
        List<List<List<Integer>>> adjList = getAdjList(V, edges);
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        int[] parent = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        parent[start] = -1;
        for (int i = 0; i < V - 1; i++) {
            int u = shortestFromStart(start, V, distance, visited);
            visited[u] = true;
            for (List<Integer> neighbour : adjList.get(u)) {
                int v = neighbour.get(0);
                int w = neighbour.get(1);
                if (u != v && !visited[v] && distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w) {
                    distance[v] = distance[u] + w;
                    parent[v] = u;
                }
            }
        }
        System.out.println("Distance: " + Arrays.toString(distance));
        System.out.println("Parent: " + Arrays.toString(parent));
    }

    private static int shortestFromStart(int start, int V, int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            if (min > distance[i] && !visited[i])
                return i;
        }
        return -1;
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
