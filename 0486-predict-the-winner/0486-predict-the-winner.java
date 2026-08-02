class Solution {

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        Integer[][] memo = new Integer[n][n];

        // Player 1 wins or ties if the final score difference is >= 0.
        return getMaximumDifference(nums, 0, n - 1, memo) >= 0;
    }

    private int getMaximumDifference(
        int[] nums,
        int left,
        int right,
        Integer[][] memo
    ) {
        // Only one number remains, so the current player takes it.
        if (left == right) {
            return nums[left];
        }

        // Return the previously calculated result.
        if (memo[left][right] != null) {
            return memo[left][right];
        }

        // Current player takes the left number.
        int takeLeft =
            nums[left] - getMaximumDifference(nums, left + 1, right, memo);

        // Current player takes the right number.
        int takeRight =
            nums[right] - getMaximumDifference(nums, left, right - 1, memo);

        // Current player chooses the option producing the larger advantage.
        memo[left][right] = Math.max(takeLeft, takeRight);

        return memo[left][right];
    }
}