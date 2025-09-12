class Solution {
    boolean[] visited;
    boolean[] safe;

    public void isSafePath(int[][] graph, int v, List<Integer> path) {
        visited[v] = true;
        boolean isSafe = true;
        for (int i = 0; i < graph[v].length; i++) {
            if (!visited[graph[v][i]]) {
                isSafePath(graph, graph[v][i], path);
            } 
            isSafe = isSafe && safe[graph[v][i]];
        }
        if (isSafe) {
            if (!safe[v]) {
                path.add(v);
            }
            safe[v] = true;
        }
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList();
        int v = graph.length;
        visited = new boolean[v];
        safe = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                List<Integer> path = new ArrayList();
                isSafePath(graph, i, path);
                ans.addAll(path);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}