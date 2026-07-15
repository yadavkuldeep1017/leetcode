class Solution {
    public int longestSubarray(int[] nums) {
        int maxLength = 0;
        int n = nums.length;
        int i = 0;
        int lastZeroIndex = -1;
        int startIndex = 0;
        boolean isZero = false;
        while(i < n){
            if(nums[i] == 0){
                if(lastZeroIndex != -1){
                    isZero = true;
                    startIndex = lastZeroIndex + 1;
                }
                lastZeroIndex = i;
            }
            else{
                maxLength = Math.max(maxLength, i - startIndex + 1 - (lastZeroIndex == -1 ? 0 : 1));
            }
            i++;
        }
        if(isZero){
            return maxLength;
        }
        return n - 1;
    }
}