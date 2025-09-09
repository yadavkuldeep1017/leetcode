class Solution {
    int[] visited;
    public boolean dfs(int[][] graph, int node, int color){
        if(visited[node] == -1){
            visited[node] = color;
            for(int i = 0; i < graph[node].length; i++){
                if(!dfs(graph, graph[node][i],color == 0 ? 1:0)){
                        return false;
                }
            }
        }
        else if(visited[node] != color){
            return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int totalNodes = graph.length;
        visited = new int[totalNodes];
        Arrays.fill(visited , -1);
        for(int i = 0; i < totalNodes; i++){
            if(visited[i] == -1){
                if(!dfs(graph, i, 0)){
                    return false;
                }
            }
        }
        for(int visit:visited){
            System.out.println(visit);
        }
        return true;
    }
}