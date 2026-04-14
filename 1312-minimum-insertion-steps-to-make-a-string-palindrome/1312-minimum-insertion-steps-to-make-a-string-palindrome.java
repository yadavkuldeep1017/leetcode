class Solution {
    int[][] dp;
    public int minOperat(String s, int i, int j){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        while(i < j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(ch1 == ch2){
                i++;
                j--;
            }
            else{
                return dp[i][j] = 1 + Math.min(minOperat(s, i, j - 1), minOperat(s, i + 1, j));
            }
        }
        return dp[i][j] = 0;
    }
    public int minInsertions(String s) {
        dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return minOperat(s, 0, s.length() - 1);        
    }
}