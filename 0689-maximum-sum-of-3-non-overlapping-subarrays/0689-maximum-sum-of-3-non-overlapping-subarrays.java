class Solution {
    long[] dp1;
    long[] dp2;
    int[] dpIndex1;
    int[] dpIndex2;

     public void maxSumTwoSubArr(int[] nums,int n,int startIndex,int k){
        long maxSum=0;
        if(startIndex+2*k<n){
            maxSumTwoSubArr(nums,n,startIndex+1,k);
            maxSum=dp1[startIndex+1];
        }
        if(dp2[startIndex+k]==0){
            maxSumOneSubArr(nums,n,startIndex+k,k);
        }
        long sum=findSum(nums,startIndex,startIndex+k)+dp2[startIndex+k];
        if(sum>=maxSum){
            dp1[startIndex]=sum;
            dpIndex1[startIndex]=startIndex;
        }else{
            dp1[startIndex]=maxSum;
            dpIndex1[startIndex]=dpIndex1[startIndex+1];
        }
     }


    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[3];
        if(k*3>n){
            return ans;
        }
        dp1=new long[n];
        dp2=new long[n];
        dpIndex1=new int[n];
        dpIndex2=new int[n];

        long currSum=findSum(nums,0,k);
        long maxSum=currSum;
        int index1=0,index2=0,index3=0;
        for(int i=k;i<=n-2*k;i++){
            if(dp1[i]==0){
                maxSumTwoSubArr(nums,n,i,k);
            }
            long sum=currSum+dp1[i];
            if(sum>maxSum){
                index1=i-k;index2=dpIndex1[i];index3=dpIndex2[index2+k];
                maxSum=sum;
            }
            System.out.println(index1+" "+index2+" "+index3);
            currSum=currSum-nums[i-k]+nums[i];
        }
        for(int i=0;i<n;i++){
            System.out.println(dpIndex1[i]+" "+dp1[i]+" "+dpIndex2[i]+" "+dp2[i]);
        }
        ans[0]=index1;ans[1]=index2;ans[2]=index3;
        return ans;
    }
    public void maxSumOneSubArr(int[] nums,int n,int startIndex,int k){
        int index=startIndex;
        long maxSum=0;
        for(int i=startIndex;i<startIndex+k;i++){
            maxSum+=nums[i];
        }
        long currentSum=maxSum;
        for(int i=startIndex+k;i<n;i++){
            currentSum=currentSum-nums[i-k]+nums[i];
            if(maxSum<currentSum){
                index=i-k+1;
                maxSum=currentSum;
            }
        }
        dp2[startIndex]=maxSum;
        dpIndex2[startIndex]=index;
    }

    

    public long findSum(int[] nums,int startIndex,int endIndex){
        long sum=0;
        for(int i=startIndex;i<endIndex;i++){
            sum+=nums[i];
        }
        return sum;
    }
}