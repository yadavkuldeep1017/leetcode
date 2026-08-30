class Solution {
    public int minimumDeletions(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int minIndex = 0;
        int maxIndex = 0;
        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(max < nums[i]){
                max = nums[i];
                maxIndex = i;
            }
            if(min > nums[i]){
                min = nums[i];
                minIndex = i;
            }
        }
        int ans = 0;
        int diff1;
        int diff2;
        int diff = Math.abs(minIndex - maxIndex);
        if(minIndex > maxIndex){
            diff1 = n - minIndex;
            diff2 = maxIndex + 1;
        }
        else{
            diff1 = n - maxIndex;
            diff2 = minIndex + 1;
        }
        if(diff1 > diff2){
            ans += diff2;
            ans += diff > diff1 ? diff1 : diff;
        }
        else{
            ans += diff1;
            ans += diff > diff2 ? diff2 : diff;
        }
        return ans;
    }
}