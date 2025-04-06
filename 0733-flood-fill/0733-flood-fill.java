class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int imageElement = image[sr][sc];
        Queue<Pair<Integer,Integer>> q = new ArrayDeque();
        q.add(new Pair(sr,sc));
        int[] drow = {-1,1,0,0};
        int[] dcol = {0,0,-1,1};
        while(!q.isEmpty()){
            Pair<Integer,Integer> pair = q.remove();
            int row = pair.getKey();
            int col = pair.getValue();
            image[row][col] = color;
            visited[row][col] = true;
            for(int i = 0; i < 4; i++){
                int currentRow = row+drow[i];
                int currentCol = col+dcol[i];
                if(currentRow>=0 && currentRow<m && currentCol>=0 && currentCol<n &&
                    image[currentRow][currentCol] == imageElement &&
                    !visited[currentRow][currentCol]){
                    q.add(new Pair(currentRow , currentCol));
                }
            }
        }
        return image;
    }
}