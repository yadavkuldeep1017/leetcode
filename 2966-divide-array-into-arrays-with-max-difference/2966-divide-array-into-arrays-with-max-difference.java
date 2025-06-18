class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int numLength = nums.length;
        Arrays.sort(nums);
        int[][] ans = new int[numLength/3][3];
        int index = 0;
        int start=0,end=2;
        while(end<numLength){
            if(nums[end]-nums[start]<=k){
                ans[index][0] = nums[start];
                ans[index][1] = nums[start+1];
                ans[index][2] = nums[end];
                index++;
                start = end + 1;
                end = start + 2;
            }
            else{
                return new int[0][0];
            }
        }
        return ans;
    }
}