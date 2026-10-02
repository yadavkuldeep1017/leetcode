class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int start = 1;
        int i = 0;
        for(i = 0; i < n; i++){
            if(nums[i] > 0){
                break;
            }
        }
        while(i < n){
            if(nums[i] == start){
                while(i + 1 < n && nums[i] == nums[i + 1]){
                    i++;
                }
                start++;
            }
            else{
                return start;
            }
            i++;
        }
        return start;
    }
}