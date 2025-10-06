class Solution {
    public void getAdjNode(int[][] grid, int i, int j, Map<Pair<Integer,Integer>,List<Pair<Integer, Integer>>> adjMap, int n){

        int[] row = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] col = {1, -1, 0, 0,  1, -1, 1, -1};
        for(int k = 0; k < 8; k++){
            int currRow = row[k] + i;
            int currCol = col[k] + j;
            if(currRow >= 0 && currRow < n && currCol >= 0 && currCol < n && 
                                                        grid[currRow][currCol] == 0){
                adjMap.get(new Pair(i,  j)).add(new Pair(currRow, currCol));
            }
        }
    }
    public Map<Pair<Integer,Integer>,List<Pair<Integer, Integer>>> getAdjMap(int[][] grid, int n){
        Map<Pair<Integer,Integer>,List<Pair<Integer, Integer>>> adjMap = new HashMap();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    adjMap.put(new Pair(i , j), new ArrayList());
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    getAdjNode(grid, i, j, adjMap,n);
                }
            }
        }
        return adjMap;

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        Map<Pair<Integer,Integer>,List<Pair<Integer, Integer>>> adjMap = getAdjMap(grid, n);
        // System.out.println(adjMap);
        Queue<Pair<Integer, Integer>> q = new ArrayDeque();
        q.add(new Pair(0, 0));
        boolean[][] visited = new boolean[n][n];
        int[][] distance = new int[n][n];
        distance[0][0] = 1;
        visited[0][0] = true;
        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            for(Pair<Integer, Integer> pair: adjMap.get(p)){
                int x = pair.getKey();
                int y = pair.getValue();
                if(x == n-1 && y == n-1){
                    return distance[p.getKey()][p.getValue()] + 1;
                }
                if(!visited[x][y]){
                    q.add(new Pair(x, y));
                    visited[x][y] = true;
                    distance[x][y] = distance[p.getKey()][p.getValue()] + 1;
                }
            }
        }
        return -1;
    }
}