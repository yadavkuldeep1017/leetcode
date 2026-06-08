class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        for(int j = 0; j < n; j++){
            if(pivot > nums[j]){
                ans[i++] = nums[j];
            }
        }
        for(int j = 0; j < n; j++){
            if(pivot == nums[j]){
                ans[i++] = nums[j];
            }
        }
        for(int j = 0; j < n; j++){
            if(pivot < nums[j]){
                ans[i++] = nums[j];
            }
        }
        return ans;
    }
}