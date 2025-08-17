class Solution {
    boolean[][] visited;
    int m;
    int n;

    public int dfs(char[][] grid,int row, int col){
        if(row == -1 || row == m || col ==-1 || col == n || visited[row][col]
            || grid[row][col] == '0'){
            return 0;
        }
        visited[row][col] = true;
        int[] rowArray = {-1, 1, 0 ,0};
        int[] colArray = {0 ,0, -1 ,1};
        for(int i = 0; i < 4; i++){
            dfs(grid, row + rowArray[i], col + colArray[i]);
        }
        return 1;
        
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for( int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ans ++;
                }
            }
        }
        return ans;
    }
}