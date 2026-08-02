class Solution {

    public int stoneWinGame(int[] piles, int start, int end, Integer[][] dp){
        if(start == end){
            return piles[start];
        }
        if(dp[start][end] != null){
            return dp[start][end];
        }
        int left = piles[start] - stoneWinGame(piles, start + 1, end, dp);
        int right = piles[end] - stoneWinGame(piles,start, end - 1, dp);
        return dp[start][end] = Math.max(left, right);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] dp = new Integer[n][n];
        return stoneWinGame(piles, 0, n - 1, dp) >= 0;
    }
}