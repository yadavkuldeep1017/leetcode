class Solution {

    public int findTarget(int[] nums,int n,int i,int newTarget){
        int target=0;
        if(i==n-1){
            if(newTarget+nums[i]==0){
                target+=1;
            }
            if(newTarget-nums[i]==0){
                target+=1;
            }
            return target;
        }
        target+=findTarget(nums,n,i+1,newTarget+nums[i]);
        target+=findTarget(nums,n,i+1,newTarget-nums[i]);
        return target;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return findTarget(nums,nums.length,0,target);
    }
}