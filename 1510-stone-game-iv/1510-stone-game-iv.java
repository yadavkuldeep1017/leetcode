class Solution {

    public int isAliceWin(int n, int[] dp){
        if(n == 1){
            return 1;
        } 
        if(dp[n] != -1){
            return dp[n];
        }
        for(int i = 1; i * i <= n; i++){
            int num = i * i;
            if(n - num == 0 || isAliceWin(n - num, dp) == 0){
                return dp[n] = 1;
            }
        }
        return dp[n] = 0;
    }
    public boolean winnerSquareGame(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);
        return isAliceWin(n, dp) == 0 ? false : true;
    }
}