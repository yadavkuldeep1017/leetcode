class Solution {

    public int isAliceWin(int n, boolean[] square, int[] dp){
        if(n == 1){
            return 1;
        } 
        if(dp[n] != -1){
            return dp[n];
        }
        for(int i = n; i >= 1; i--){
            if(square[i] && (n - i == 0 || 
            (isAliceWin(n - i, square, dp) == 0))){
                return dp[n] = 1;
            }
        }
        return dp[n] = 0;
    }
    public boolean winnerSquareGame(int n) {
        boolean[] square = new boolean[n + 1];
        for (int i = 1; i * i <= n; i++) {
            square[i * i] = true;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);
        return isAliceWin(n, square, dp) == 0 ? false : true;
    }
}