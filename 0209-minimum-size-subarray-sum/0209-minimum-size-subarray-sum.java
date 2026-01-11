class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minSubLen = Integer.MAX_VALUE;
        int currSum = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            // while (currSum > target) {
            //     currSum -= nums[start];
            //     start += 1;
            // }
            while (currSum >= target) {
                minSubLen = Math.min(minSubLen, i - start + 1);
                currSum -= nums[start];
                start += 1;

            }
        }
        return minSubLen == Integer.MAX_VALUE ? 0 : minSubLen;
    }
}