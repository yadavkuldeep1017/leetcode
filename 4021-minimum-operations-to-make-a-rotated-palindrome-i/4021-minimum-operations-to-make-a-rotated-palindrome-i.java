class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int ans = Integer.MAX_VALUE;

        for (int rotation = 0; rotation < n; rotation++) {
            int cost = rotation;

            int left = rotation;
            int right = rotation + n - 1;

            while (left < right) {
                char a = s.charAt(left % n);
                char b = s.charAt(right % n);

                int diff = Math.abs(a - b);
                cost += Math.min(diff, 26 - diff);

                left++;
                right--;
            }
            ans = Math.min(ans, cost);
        }
        return ans;
    }
}