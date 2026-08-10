class Solution {

    public int isAliceWin(int n, boolean[] square, int[][] dp, int turn){
        if(n == 1){
            return 1;
        } 
        if(dp[n][turn] != -1){
            return dp[n][turn];
        }
        for(int i = n; i >= 1; i--){
            if(square[i] && (n - i == 0 || 
            (isAliceWin(n - i, square, dp, turn == 0 ? 1 : 0) == 0)
            )){
                return dp[n][turn] = 1;
            }
        }
        return dp[n][turn] = 0;
    }
    public boolean winnerSquareGame(int n) {
        boolean[] square = new boolean[n + 1];
        for (int i = 1; i * i <= n; i++) {
            square[i * i] = true;
        }
        int[][] dp = new int[n + 1][2];
        for(int i = 1; i <= n; i++){
            Arrays.fill(dp[i] , -1);
        }
        return isAliceWin(n, square, dp, 0) == 0 ? false : true;
    }
}