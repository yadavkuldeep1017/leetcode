class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1){
            return -1;
        }
        int[][] distance = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList();//{i, j, dist}
        q.add(new int[]{0, 0, 1});
        distance[0][0] = 1;
        while(!q.isEmpty()){
            int[] path = q.poll();
            int r = path[0];
            int c = path[1];
            int d = path[2];
            int[] rowArr = {1,-1, 0, 0, 1, 1, -1, -1};
            int[] colArr = {0, 0, 1, -1, 1, -1, 1, -1};
            for(int i = 0; i < 8; i++){
                int nr = r + rowArr[i];
                int nc = c + colArr[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && distance[nr][nc] > d + 1){
                    distance[nr][nc] = d + 1;
                    q.add(new int[]{nr, nc, d + 1});
                }
            }
        }
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(distance[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return distance[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : distance[n - 1][n - 1];
    }
}