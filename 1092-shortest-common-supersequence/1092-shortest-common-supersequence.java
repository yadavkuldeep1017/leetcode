class Solution {
    public int[][] longestCommonSubsequence(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i + 1][j + 1] = 1 + dp[i][j]; 
                }
                else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp;
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        if(str1.equals(str2)){
            return str1;
        }
        int[][] dp = longestCommonSubsequence(str1, str2);
        int i = str1.length();
        int j = str2.length();
        StringBuilder str = new StringBuilder();
        while(i > 0 && j > 0){
            char ch1 = str1.charAt(i - 1);
            char ch2 = str2.charAt(j - 1);
            // System.out.println(ch1 + " "+ ch2);
            if(ch1 == ch2){
                str.append(ch1);
                i--;
                j--;
            }
            else{
                if(dp[i][j] == dp[i][j - 1]){
                    str.append(ch2);
                    j--;
                }
                else{
                    str.append(ch1);
                    i--;
                }
            }
        }
        while(i > 0){
            str.append(str1.charAt(--i));
        }
        while(j > 0){
            str.append(str2.charAt(--j));
        }
        // for(int i = 0; i <= str1.length(); i++){
        //     for(int j = 0; j <= str2.length(); j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(str.toString());
        return str.reverse().toString();
    }
}