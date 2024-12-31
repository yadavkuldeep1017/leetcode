class Solution {
    int[] dp;

    public int minCost(int[] days, int n, int[] costs, int index, int cutOffDate) {
        if (index == n) {
            return 0;
        }
        if (cutOffDate > days[index]) {
            return minCost(days, n, costs, index + 1, cutOffDate);
        }
        if (dp[index] != 0) {
            return dp[index];
        }
        int one = costs[0] + minCost(days, n, costs, index + 1, days[index] + 1);
        int seven = costs[1] + minCost(days, n, costs, index + 1, days[index] + 7);
        int month = costs[2] + minCost(days, n, costs, index + 1, days[index] + 30);
        // System.out.println(index+" "+Math.min(one, Math.min(seven, month)));
        return dp[index] = Math.min(one, Math.min(seven, month));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        dp = new int[n];
        int ans = minCost(days, n, costs, 0, 0);
        // for (int i = 0; i < n; i++) {
        //     System.out.println(dp[i]);
        // }
        return ans;
    }
}