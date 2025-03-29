class Solution {
    boolean[] visited;

    public void traverseGraph(int[][] isConnected, int vertex, int n) {
        if (visited[vertex]) {
            return;
        }
        visited[vertex] = true;
        for (int i = 0; i < n; i++) {
            if (i != vertex && isConnected[vertex][i] == 1) {
                traverseGraph(isConnected, i, n);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    traverseGraph(isConnected, j, n);
                }
            }
            ans++;
        }
        return ans;
    }
}