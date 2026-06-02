class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int maxLen = 0;
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            // Expand the window: count the zero if we encounter one
            if (nums[i] == 0) {
                zeroCount++;
            }

            // Shrink the window: if zeros exceed k, move the start pointer
            while (zeroCount > k) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }

            // Update the maximum window size found so far
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }
}