import java.util.*;

class Solution {
    boolean[] visited;
    boolean[] safe;

    public List<List<Integer>> getAdjList(int[][] prerequisites, int v) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
        }

        return adjList;
    }

    public boolean dfs(List<List<Integer>> adjList, int node) {
        if (visited[node]) {
            return safe[node];  // If visited, return whether it's safe (no cycle)
        }

        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!dfs(adjList, neighbor)) {
                return false;
            }
        }

        safe[node] = true;  // Mark node safe only after all neighbors are safe
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = getAdjList(prerequisites, numCourses);
        visited = new boolean[numCourses];
        safe = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjList, i)) {
                return false;
            }
        }

        return true;
    }
}
