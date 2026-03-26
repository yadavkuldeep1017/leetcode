class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] distance = new int[row][col];
        Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j, 0});
                    distance[i][j] = 0;
                }
                else{
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[] delrow = {-1, 1, 0, 0};
        int[] delcol = {0, 0, -1, 1};
        while(!q.isEmpty()){
            
            int[] qPoll = q.poll();
            distance[qPoll[0]][qPoll[1]] = qPoll[2];
            for(int i = 0; i < 4; i++){
                int nrow = qPoll[0] + delrow[i];
                int ncol = qPoll[1] + delcol[i];
                if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < col && distance[nrow][ncol] == Integer.MAX_VALUE){
                    distance[nrow][ncol] = 1;
                    q.add(new int[]{nrow, ncol, qPoll[2] + 1});
                }

            }

        }
        return distance;
    }
}