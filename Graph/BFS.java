import java.util.Deque;
import java.util.ArrayDeque;

public class BFS {
    public static void main(String[] args) {
        int[][] adjMat = new int[][] { { 0, 1, 1, 0 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 0, 0, 1, 0 } };
        int v = adjMat.length;
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                bfs(adjMat, visited, i);
            }
        }
    }

    private static void bfs(int[][] adjMat, boolean[] visited, int v) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        visited[v] = true;
        int n = adjMat.length;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            System.out.print(i + " ");
            for (int j = 0; j < n; j++) {
                if (adjMat[i][j] == 1 && !visited[j] && j != i) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }
}
