class Solution {
    public int dfs(int[][] obstacleGrid, int m, int n, int[][] visited,int row, int col){
        if(row == m || col == n 
        || obstacleGrid[row][col] == 1){
            return 0;
        }
        if(row == m - 1 && col == n - 1){
            return 1;
        }
        if(visited[row][col] != -1){
            return visited[row][col];
        }
        
        return visited[row][col] = dfs(obstacleGrid, m, n, visited, row + 1, col) + dfs(obstacleGrid, m, n, visited, row, col + 1);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(visited[i], -1);
        }
        return dfs(obstacleGrid, m, n, visited, 0, 0);
    }
}