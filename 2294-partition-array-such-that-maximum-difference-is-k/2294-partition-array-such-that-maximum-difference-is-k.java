class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int start = 0;
        int end = 1;
        while(end < nums.length){
            if(nums[end] - nums[start] > k){
                ans++;
                start = end;
            }
            end++;
        }
        return ans;
    }
}