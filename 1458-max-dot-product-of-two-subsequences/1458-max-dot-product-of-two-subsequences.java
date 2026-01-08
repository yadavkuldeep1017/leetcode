class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int min = Integer.MIN_VALUE;
        Arrays.fill(dp[0], min);
        for(int i = 1; i <= m; i++){
            dp[i][0] = min;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int currProduct = nums1[i - 1] * nums2[j - 1];
                if(dp[i - 1][j - 1] > 0){
                    currProduct = currProduct + dp[i - 1][j - 1];
                }
                dp[i][j] = Math.max(currProduct, Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m][n];
    }
}