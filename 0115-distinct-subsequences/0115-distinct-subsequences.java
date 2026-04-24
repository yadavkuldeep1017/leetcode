class Solution {

    public int[][] lcs(String s, String t){
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i -1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }

    public int findDistinct(String s, String t, int[][] dp, int i, int j, int[][] visited){
        if(i == 0 || j == 0){
            return 1;
        }
        if(dp[i][j] == 0){
            return 0;
        }
        if(visited[i - 1][j - 1] != Integer.MAX_VALUE){
            return visited[i - 1][j - 1];
        }
        int ans = 0;
        if(s.charAt(i - 1) == t.charAt(j - 1)){
            ans = findDistinct(s, t, dp, i - 1, j - 1, visited);
        }
        if(dp[i - 1][j] == dp[i][j]){
            ans += findDistinct(s, t, dp, i - 1, j,visited);
        }
        if(dp[i][j - 1] == dp[i][j]){
            ans += findDistinct(s, t, dp, i, j - 1, visited);
        }
        return visited[i - 1][j - 1] = ans;
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m < n){
            return 0;
        }
        int[][] dp = lcs(s, t);
        if(dp[m][n] != n){
            return 0;
        }
        // for(int i = 0; i <= s.length(); i++){
        //     for(int j = 0; j <= t.length(); j++){
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println();
        // }
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        return findDistinct(s, t, dp, m, n,visited);
        // return 0;
    }
}