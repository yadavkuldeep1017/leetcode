class Solution {

    public boolean isPossibleEnd(int[] nums, int index, int n,
    int[] dp){
        if(index == n){
            return true;
        }
        if(index > n){
            return false;
        }
        if(dp[index] != -1){
            return dp[index] == 1 ? true : false;
        }
        for(int i = 1; i <= nums[index]; i++){
            if(isPossibleEnd(nums,  index + i, n, dp)){
                dp[index + i] = 1;
                return true;
            }
        }
        dp[index] = 0;
        return false;
    }

    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return isPossibleEnd(nums, 0, nums.length - 1, dp);
    }
}