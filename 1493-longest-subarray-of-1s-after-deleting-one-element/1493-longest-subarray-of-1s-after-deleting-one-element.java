class Solution {
    public int longestSubarray(int[] nums) {
        int maxLength = 0;
        int n = nums.length;
        int i = 0;
        int lastZeroIndex = -1;
        int startIndex = 0;
        while(i < n){
            int noOfZeros = lastZeroIndex == -1 ? 0 : 1;
            if(nums[i] == 0){
                if(lastZeroIndex != -1){
                    startIndex = lastZeroIndex + 1;
                }
                lastZeroIndex = i;
            }
            else{
                maxLength = Math.max(maxLength, i - startIndex + 1 - noOfZeros);
            }
            i++;
        }
        return maxLength == n ? n - 1 : maxLength;
    }
}