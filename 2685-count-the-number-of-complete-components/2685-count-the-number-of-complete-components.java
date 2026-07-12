import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] res = dfs(i, graph, visited);
                int nodes = res[0];
                int degreeSum = res[1];

                // For a complete graph: degreeSum = nodes * (nodes - 1)
                if (degreeSum == nodes * (nodes - 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private int[] dfs(int u, List<List<Integer>> graph, boolean[] visited) {
        visited[u] = true;
        int nodes = 1;
        int degreeSum = graph.get(u).size();

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                int[] child = dfs(v, graph, visited);
                nodes += child[0];
                degreeSum += child[1];
            }
        }

        return new int[]{nodes, degreeSum};
    }
}