class Solution {
    final int maxValue = Integer.MAX_VALUE;
    public int minJump(int[] nums, int index, int n,
    int[] dp){
        if(index == n){
            return 0;
        }
        if(index > n){
            return maxValue;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int minJump = maxValue;
        for(int i = nums[index]; i > 0 ; i--){
            int jump = minJump(nums,  index + i, n, dp);
            if(jump != maxValue){
                minJump = Math.min(minJump, jump + 1);
            }            
        }
        return dp[index] = minJump;
    }


    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int ans = minJump(nums, 0, nums.length - 1,dp);
        // for(int i:dp){
        //     System.out.println(i);
        // }
        return ans;
    }
}