class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] temp = new int[10000];
        Arrays.fill(temp, 0);
        for(int i = 0; i < nums.length; i++){
            if(temp[nums[i]] != 0){
                return nums[i];
            }
            temp[nums[i]] = 1;
        }
        return 0;
    }
}