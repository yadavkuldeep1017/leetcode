class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, 1, -1};
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0; j < size; j++){
                int[] mz = q.poll();
                for(int i = 0; i < 4; i++){
                    int newRow = mz[0] + row[i];
                    int newCol = mz[1] + col[i];
                    int newDistance = mz[2] + 1;
                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.'){
                        if(newRow == 0 || newRow == m - 1 || newCol == 0 || newCol == n - 1){
                            return newDistance;
                        }
                        q.add(new int[]{newRow, newCol, newDistance});
                        maze[newRow][newCol] = '+';
                    }
                }
            }
        }
        return -1;
    }
}