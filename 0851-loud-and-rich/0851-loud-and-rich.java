class Solution {
    public List<List<Integer>> getAdjList(int[][] richer, int v){
        List<List<Integer>> adjList = new ArrayList();
        for(int i = 0; i < v; i++){
            adjList.add(new ArrayList());
        }
        for(int i = 0; i < richer.length; i++){
            adjList.get(richer[i][1]).add(richer[i][0]);
        }
        return adjList;
    }
    boolean[] visited;
    int[] ans;
    public int minQuietNode(List<List<Integer>> list, int v, int[] quiet){
        if(visited[v]){
            return ans[v];
        }
        visited[v] = true;
        int min = quiet[v];
        ans[v] = v;
        for(int num:list.get(v)){
            int node = minQuietNode(list,num,quiet);
            if(min >= quiet[node]){
                ans[v] = node;
                min = quiet[node];
            }
        }
        return ans[v];
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int v = quiet.length;
        List<List<Integer>> adjList = getAdjList(richer,v);
        visited = new boolean[v];
        ans = new int[v];
        for(int i = 0; i < v; i++){
            if(!visited[i]){
                minQuietNode(adjList, i,quiet);
            }
        }
        return ans;
    }
}