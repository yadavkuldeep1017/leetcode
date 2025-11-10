class Solution {
    int row;
    int col;
    int[][] distance;

    public int minimumEffortPath(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        distance = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        Queue<DJ> q = new ArrayDeque();
        q.add(new DJ(0, 0, 0));
        distance[0][0] = 0;
        while (!q.isEmpty()) {
            DJ queue = q.poll();
            int[] currRow = { -1, 1, 0, 0 };
            int[] currCol = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int r = queue.x + currRow[i];
                int c = queue.y + currCol[i];
                if (r < 0 || r == row || c < 0 || c == col) {
                    continue;
                }
                int diff = Math.abs(heights[r][c] - heights[queue.x][queue.y]);
                int absDistance = Math.max(diff, queue.distance);
                if (distance[r][c] > absDistance) {
                    distance[r][c] = absDistance;
                    q.add(new DJ(distance[r][c], r, c));
                }
            }
        }
        return distance[row - 1][col - 1];
    }

    static class DJ {
        public int distance;
        public int x;
        public int y;

        DJ(int distance, int x, int y) {
            this.distance = distance;
            this.x = x;
            this.y = y;
        }
    }
}
