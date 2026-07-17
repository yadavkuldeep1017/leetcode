class Solution {
    public void dfs(List<List<Integer>> rooms, int n, int room, boolean[] visited){
        if(visited[room]){
            return;
        }
        visited[room] = true;
        for(int key : rooms.get(room)){
            dfs(rooms, n, key, visited);
        }

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, n, 0,visited);
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}