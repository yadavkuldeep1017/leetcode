import java.util.*;

class Solution {
    int ans = Integer.MAX_VALUE;
    private void dfs(int node, List<List<int[]>> adj, boolean[] visited) {
        visited[node] = true;

        for (int[] edge : adj.get(node)) {
            int next = edge[0];
            int weight = edge[1];

            ans = Math.min(ans, weight);

            if (!visited[next]) {
                dfs(next, adj, visited);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        boolean[] visited = new boolean[n + 1];
        dfs(1, adj, visited);
        return ans;
    }
}