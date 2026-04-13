class Solution {
    public int lcs(String a, String b){
        int n = a.length();
        int[][] dp = new int[n + 1][n + 1];
        Arrays.fill(dp[0], 0);
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i <= n; i++){
            char ch = a.charAt(i - 1);
            for(int j = 1; j <= n; j++){
                if(ch == b.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i -1][j]);
                }
            }
        }
        return dp[n][n];
    }
    public int longestPalindromeSubseq(String s) {
        return lcs(s, reverse(s));
    }
    public String reverse(String s){
        StringBuilder str = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}