class Solution {

    boolean[][] visited;
    int m;
    int n;
    int row;
    int col;

    public boolean isValidPath(int i, int j) {
        return !(i == -1 || i == m || j == -1 || j == n);
    }

    public boolean isCycle(char[][] grid, int i, int j, int pI, int pJ) {
        if (visited[i][j]) {
            return true;
        }
        visited[i][j] = true;
        int[] rowArr = { 1, -1, 0, 0 };
        int[] colArr = { 0, 0, 1, -1 };

        for (int k = 0; k < 4; k++) {
            int currRow = i + rowArr[k];
            int currCol = j + colArr[k];
            if (pI == currRow && pJ == currCol) {
                continue;
            } else if (isValidPath(currRow, currCol) &&
                    grid[i][j] == grid[currRow][currCol] && isCycle(grid, currRow, currCol, i, j)) {
                return true;
            }
        }
        return false;

    }

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    row = i;
                    col = j;
                    // System.out.println(row + " "+ col);
                    boolean cy = isCycle(grid, i, j, -1, -1);
                    System.out.println(cy);
                    if (cy) {
                        return true;
                    }
                    for (int k = 0; k < m; k++) {
                        System.out.println(Arrays.toString(visited[k]));

                    }
                }
            }
        }

        return false;
    }
}