class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int longSeq = 0;
        int i = 0;
        int n = nums.length;
        while(i < n){
            int count = 1;
            while(i + 1 < n && nums[i + 1] - nums[i] < 2){
                if(nums[i + 1] - nums[i] == 1){
                    count++;
                }
                i++;
            }
            longSeq = Math.max(longSeq, count);
            i++;
        }
        return longSeq;
    }
}