class Solution {

    public boolean isSafe(int[][] board, int n, int row, int col) {

        for (int i = 0; i < n; i++) {
            if (board[i][col] == 1 || board[row][i] == 1) {
                return false;
            }
        }
        int[] rowArray = { 1, 1, -1, -1 };
        int[] colArray = { 1, -1, 1, -1 };
        for (int i = 0; i < 4; i++) {
            int a = row + rowArray[i];
            int b = col + colArray[i];
            while (a >= 0 && a < n && b >= 0 && b < n) {
                if (board[a][b] == 1) {
                    return false;
                }
                a += rowArray[i];
                b += colArray[i];
            }
        }
        return true;
    }

    public int totalQueens(int[][] board, int n, int row) {
        if (row == n) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (isSafe(board, n, row, i)) {
                board[row][i] = 1;
                ans += totalQueens(board, n, row + 1);
                board[row][i] = 0;
            }
        }
        return ans;
    }

    public int totalNQueens(int n) {
        return totalQueens(new int[n][n], n, 0);
    }
}