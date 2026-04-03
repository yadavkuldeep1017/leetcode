class Solution {
    public boolean isExistWord(char[][] board, String word, boolean[][] visited, int r, int c, int index) {
        if(index == word.length()){
            return true;
        }
        visited[r][c] = true;
        int m = board.length;
        int n = board[0].length;
        int[] rowArr = {-1, 1, 0, 0};
        int[] colArr = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++){
            int newRow = r + rowArr[i];
            int newCol = c + colArr[i];
            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol] && word.charAt(index) == board[newRow][newCol] && isExistWord(board, word, visited, newRow, newCol, index + 1 )){
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boolean[][] visited = new boolean[m][n];
                if(board[i][j] == word.charAt(0) && isExistWord(board, word, visited, i, j, 1)){
                    return true;
                }
            }
        }
        return false;
    }
}