class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length){
            int count = 1;
            i++;
            while(i < nums.length && nums[i] == nums[i - 1]){
                i++;
                count++;
            }
            if(count > nums.length/2){
                return nums[i - 1];
            }
        }
        return -1;
    }
}