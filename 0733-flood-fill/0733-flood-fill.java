class Solution {
    public void dfs(int sr, int sc, int m, int n, int[][]image, boolean[][] visited){
        visited[sr][sc] = true;
        int[] rowArr = {-1, 1, 0, 0};
        int[] colArr = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++){
            int nRow = sr + rowArr[i];
            int nCol = sc + colArr[i];
            if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol] && image[nRow][nCol] == image[sr][sc]){
                dfs(nRow, nCol, m, n, image, visited);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color){
            int m = image.length;
            int n = image[0].length;
            boolean[][] visited = new boolean[m][n];
            dfs(sr, sc, m, n, image, visited);
            for(int i = 0; i< m; i++){
                for(int j = 0; j < n; j++){
                    // System.out.print(visited[i][j]+" ");
                    if(visited[i][j]){
                        image[i][j] = color;
                    }
                }
                // System.out.println();
            }
        }
        return image;
    }
}