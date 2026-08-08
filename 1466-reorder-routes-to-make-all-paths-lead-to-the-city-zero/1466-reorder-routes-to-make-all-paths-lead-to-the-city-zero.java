import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph with direction info
        for (int[] e : connections) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(new int[]{b, 1}); // original direction a -> b
            graph.get(b).add(new int[]{a, 0}); // reverse traversal only
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] next : graph.get(node)) {
            int neighbor = next[0];
            int cost = next[1];

            if (!visited[neighbor]) {
                changes += cost;
                changes += dfs(neighbor, graph, visited);
            }
        }

        return changes;
    }
}