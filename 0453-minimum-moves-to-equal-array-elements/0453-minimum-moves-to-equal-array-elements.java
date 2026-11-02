class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[0];
        int max = nums[n - 1];
        if(min == max){
            return 0;
        }
        int ans = 0;
        int index = n - 2;
        int diff = max - min;
        while(index > 0){
            ans += diff;
            min = max;
            max = nums[index] + ans;
            diff = max - min;
            index--;
        }
        return ans + diff;


    }
}