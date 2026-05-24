class Solution {

    public int snakesAndLadders(int[][] board) {

        int n = board.length;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        q.offer(1);
        visited[1] = true;

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {

                int curr = q.poll();

                if (curr == n * n) {
                    return moves;
                }

                for (int dice = 1; dice <= 6 && curr + dice <= n * n; dice++) {

                    int next = curr + dice;

                    int[] pos = getCoordinates(next, n);

                    int row = pos[0];
                    int col = pos[1];

                    // snake or ladder
                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private int[] getCoordinates(int num, int n) {

        int row = n - 1 - (num - 1) / n;

        int col = (num - 1) % n;

        // reverse direction on alternating rows
        if ((n - 1 - row) % 2 == 1) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }
}