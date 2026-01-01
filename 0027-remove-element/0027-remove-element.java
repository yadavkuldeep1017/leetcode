class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int[] ans = new int[nums.length];
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                count += 1;
            }
            else{
                nums[k++] = nums[i];
            }
        }
        return nums.length - count;
    }
}