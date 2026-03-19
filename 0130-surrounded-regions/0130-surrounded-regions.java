class Solution {

    public void dfs(int i, int j, char[][] board, boolean[][] vis){
        vis[i][j] = true;
        int m = board.length;
        int n = board[0].length;
        int[] rowArr = {-1, 1, 0, 0};
        int[] colArr = {0, 0, -1, 1};
        for(int k = 0; k < 4; k++){
            int nRow = i + rowArr[k];
            int nCol = j + colArr[k];
            if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && board[nRow][nCol] == 'O' && !vis[nRow][nCol]){
                dfs(nRow, nCol, board, vis);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < n; i++){
            //first row
            if(board[0][i] == 'O' && !visited[0][i]){
                dfs(0, i, board, visited);
            }
            //last row
            if(board[m-1][i] == 'O' && !visited[m - 1][i]){
                dfs(m - 1, i, board, visited);
            }
        }
        for(int i = 0; i < m; i++){
            //first col
            if(board[i][0] == 'O' && !visited[i][0]){
                dfs(i, 0, board, visited);
            }
            // last col
            if(board[i][n-1] == 'O' && !visited[i][n-1]){
                dfs(i, n - 1, board, visited);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}