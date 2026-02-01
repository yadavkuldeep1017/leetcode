class Solution {
    public int minimumCost(int[] nums) {
        int ans = nums[0];
        nums[0] = Integer.MAX_VALUE;
        Arrays.sort(nums);
        return nums[0] + nums[1] + ans;
    }
}