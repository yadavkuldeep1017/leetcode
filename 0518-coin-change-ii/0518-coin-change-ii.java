class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(j >= coins[i - 1]){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // for(int i = 0; i <= n; i++){
        //     for(int j = 0; j <= amount; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[n][amount];
    }
}