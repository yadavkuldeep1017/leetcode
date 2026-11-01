class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0L;
        int n = nums.length;
        int start = -1;
        for(int i = 0; i < n; i++){
            if(nums[i] >= minK && nums[i] <= maxK){
                if(start == -1){
                    start = i;
                    ans += 1;
                }
                else{
                    int diff = i - start;
                    ans += diff + 1;
                }
            }
            else{
                start = -1;
            }
        }
        return ans;   
    }
}