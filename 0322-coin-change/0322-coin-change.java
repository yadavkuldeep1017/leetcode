class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[][] dp = new int[m + 1][amount + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for(int i = 0; i < m; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i - 1] <= j){
                int previousValue = dp[i][j - coins[i - 1]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + dp[i][j - coins[i - 1]];
                    dp[i][j] = Math.min(dp[i - 1][j], previousValue);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
                // System.out.println(coins[i - 1] + " "+ j +" " + dp[i][j]);
            }
        }
        // for(int i = 0; i <= m; i++){
        //     for(int j = 0; j <= amount; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[m][amount] == Integer.MAX_VALUE ? -1 : dp[m][amount];
    }
}