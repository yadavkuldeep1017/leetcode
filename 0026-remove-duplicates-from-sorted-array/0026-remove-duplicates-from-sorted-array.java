class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int i = 0;
        int k = 0;
        while(i < nums.length){
            nums[k++] = nums[i++];
            count++;
            while(i < nums.length && nums[i - 1] == nums[i]){
                i++;
            }
        }
        return count;
    }
}