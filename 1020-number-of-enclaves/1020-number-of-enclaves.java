class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair<Integer,Integer>>  q = new ArrayDeque();
        //first row
        for(int i = 0; i < n; i++){
            if(grid[0][i] == 1){
                visited[0][i] = true;
                q.add(new Pair(0, i));
            }
        }

        //last row
        for(int i = 0; i < n; i++){
            if(grid[m - 1][i] == 1){
                visited[m - 1][i] = true;
                q.add(new Pair(m - 1, i));
            }
        }

        //first col
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1){
                visited[i][0] = true;
                q.add(new Pair(i, 0));
            }
        }

        //last col
        for(int i = 0; i < m; i++){
            if(grid[i][n - 1] == 1){
                visited[i][n - 1] = true;
                q.add(new Pair(i, n - 1));
            }
        }

        while(!q.isEmpty()){
            Pair<Integer,Integer> pair = q.poll();
            int[] delRow = {-1, 1, 0, 0};
            int[] delCol = {0, 0, -1, 1};
            for(int i = 0; i < 4; i++){
                int nrow = pair.getKey() + delRow[i];
                int ncol = pair.getValue() + delCol[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1 && !visited[nrow][ncol]){
                    q.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = true;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}