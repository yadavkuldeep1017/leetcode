class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{entrance[0], entrance[1]});
        visited[entrance[0]][entrance[1]] = true;
        int path = 1;
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, 1, -1};
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0; j < size; j++){
                int[] mz = q.poll();
                for(int i = 0; i < 4; i++){
                    int newRow = mz[0] + row[i];
                    int newCol = mz[1] + col[i];
                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.' && !visited[newRow][newCol]){
                        if(newRow == 0 || newRow == m - 1 || newCol == 0 || newCol == n - 1){
                            return path;
                        }
                        q.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            path++;
        }
        return -1;
    }
}