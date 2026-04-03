class Solution {

    public boolean dfs(char[][] board, String word, int r, int c, int index) {
        // ✅ All characters matched
        if (index == word.length()) {
            return true;
        }

        int m = board.length;
        int n = board[0].length;

        // ❌ Boundary + mismatch check
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(index)) {
            return false;
        }

        // 🔥 Mark visited (in-place)
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore all 4 directions
        boolean found = dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1);

        // 🔥 Backtrack (restore original value)
        board[r][c] = temp;

        return found;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}