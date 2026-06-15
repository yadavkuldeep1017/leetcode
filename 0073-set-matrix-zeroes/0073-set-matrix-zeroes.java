class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet();
        Set<Integer> cols = new HashSet();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    cols.add(j);
                }
            }
        }
        for(int num: row){
            Arrays.fill(matrix[num], 0);
        }
        for(int num: cols){
            for(int i = 0; i < m; i++){
                matrix[i][num] = 0;
            }
        }
    }
}