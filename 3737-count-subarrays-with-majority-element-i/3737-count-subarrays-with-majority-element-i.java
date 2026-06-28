class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int countOf2 = 0;
            if(nums[i] == target){
                countOf2++;
                ans++;
            }
            for(int j = i + 1; j < n; j++){
                if(nums[j] == target){
                    countOf2++;
                }
                if(countOf2 > (j -i + 1)/2){
                    ans++;
                }
            }
        }
        return ans;
    }
}