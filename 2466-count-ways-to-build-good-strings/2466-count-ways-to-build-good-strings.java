class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod=(int)1e9+7;
        int ans=0;
        int[] dp=new int[high+1];
        dp[0]=1;
        for(int i=1;i<=high;i++){
            int sum=0;
            if(zero<=i){
                sum=(sum+dp[i-zero])%mod;
            }
            if(one<=i){
                sum=(sum+dp[i-one])%mod;
            }
            // System.out.println(sum);
            dp[i]=sum;
            if(i>=low){
                ans=(ans+dp[i])%mod;
            }
        }
        return ans;
    }
}