class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0L;
        int n = nums.length;
        int start = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] >= minK && nums[i] <= maxK){
                ans += i - start + 1;
            }
            else{
                start = i + 1;
            }
        }
        return ans;   
    }
}