class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for(int i = 1; i < n; i++){
            prefix[i] = Math.max(nums[i], prefix[i - 1]);
        }
        for(int i = n - 2; i >= 0; i--){
            suffix[i] = Math.min(suffix[i + 1], nums[i]);
        }
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < n; i++){
            int diff = Math.abs(prefix[i] - suffix[i]);
            if(diff <= k){
                return i;
            }
        }
        return -1;
    }
}