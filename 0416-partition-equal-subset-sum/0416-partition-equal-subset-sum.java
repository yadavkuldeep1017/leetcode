class Solution {
    public boolean isSubsetSum(int[] nums, int sum ){
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(nums[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - nums[i - 1]]);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // for(int i = 0; i <= n;i++){
        //     for(int j = 0; j <= sum; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[n][sum];
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i = 0;i < nums.length;i++){
            totalSum += nums[i];
        }
        if((totalSum & 1) == 1){
            return false;
        }
        return isSubsetSum(nums,totalSum/2);
    }
}