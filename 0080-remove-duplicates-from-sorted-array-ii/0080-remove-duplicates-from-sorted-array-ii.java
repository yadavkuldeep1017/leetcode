class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int count = 0;
        int k = 0;
        while(i < nums.length){
            nums[k++] = nums[i++];
            count++;
            if(i < nums.length && nums[i] == nums[i - 1]){
                nums[k++] = nums[i++];
                count++;
            }
            while(i < nums.length && nums[i] == nums[i - 1]){
                i++;
            }
        }
        return count;
    }
}