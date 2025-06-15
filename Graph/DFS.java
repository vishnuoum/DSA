public class DFS {
    public static void main(String[] args) {
        int[][] adjMat = new int[][] { { 0, 1, 1, 0 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 0, 0, 1, 0 } };
        int v = adjMat.length;
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(adjMat, visited, i);
            }
        }
    }

    private static void dfs(int[][] adjMat, boolean[] visited, int v) {
        if (visited[v])
            return;
        System.out.print(v + " ");
        visited[v] = true;
        int n = adjMat.length;
        for (int i = 0; i < n; i++) {
            if (adjMat[v][i] == 1 && i != v) {
                dfs(adjMat, visited, i);
            }
        }
    }
}
