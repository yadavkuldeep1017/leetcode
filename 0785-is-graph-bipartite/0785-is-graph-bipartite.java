class Solution {
    public boolean isBipartite(int[][] graph) {
        int totalNodes = graph.length;
        int[] visited = new int[totalNodes];
        Arrays.fill(visited, -1);
        int currentNum = 0;
        Queue<Integer> q = new ArrayDeque();
        q.add(0);
        while (!q.isEmpty()) {
            Queue<Integer> tempQ = new ArrayDeque();
            int nextNum = currentNum == 0 ? 1 : 0;
            while (!q.isEmpty()) {
                int num = q.poll();
                if (visited[num] == -1) {
                    visited[num] = currentNum;
                }
                int nodesLength = graph[num].length;
                for (int i = 0; i < nodesLength; i++) {
                    int node = graph[num][i];
                    if (visited[node] == -1) {
                        tempQ.add(node);
                    } else if (currentNum == visited[node]) {
                        return false;
                    }
                }
            }
            q = tempQ;
            currentNum = nextNum;
        }
        return true;
    }
}