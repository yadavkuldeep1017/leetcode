class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] distance = new int[row][col];
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Initialize queue with all 0s
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] delrow = {-1, 1, 0, 0};
        int[] delcol = {0, 0, -1, 1};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + delrow[i];
                int nc = c + delcol[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col) {
                    if (distance[nr][nc] > distance[r][c] + 1) {
                        distance[nr][nc] = distance[r][c] + 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return distance;
    }
}