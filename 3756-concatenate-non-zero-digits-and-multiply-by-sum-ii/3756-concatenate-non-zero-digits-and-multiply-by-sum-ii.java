class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int mod = 1000000007;
        int n = s.length();
        int qLength = queries.length;
        int[] ans = new int[qLength];
        
        // 1. Precompute powers of 10 modulo 1000000007
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }
        
        // 2. Build Prefix Arrays
        int[] sumD = new int[n + 1];     // Prefix sum of digits
        int[] cntN0 = new int[n + 1];    // Prefix count of non-zero digits
        long[] p = new long[n + 1] ;     // Prefix number formed by non-zero digits
        
        for (int i = 1; i <= n; i++) {
            int d = s.charAt(i - 1) - '0';
            
            sumD[i] = sumD[i - 1] + d;
            cntN0[i] = cntN0[i - 1] + (d > 0 ? 1 : 0);
            
            // If the digit is non-zero, push it into our rolling number 'p'
            if (d > 0) {
                p[i] = (p[i - 1] * 10 + d) % mod;
            } else {
                p[i] = p[i - 1]; // Zeros are ignored completely when forming x
            }
        }
        
        // 3. Process each query in O(1) time
        for (int i = 0; i < qLength; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            
            // Number of non-zero digits in the range [l, r]
            int n0 = cntN0[r + 1] - cntN0[l];
            
            // Sum of digits in the range [l, r]
            long sd = sumD[r + 1] - sumD[l];
            
            // Extract the concatenated non-zero number in range [l, r]
            // Equation: x = (p[r+1] - p[l] * 10^n0) % mod
            long x = (p[r + 1] - (p[l] * pow10[n0]) % mod + mod) % mod;
            
            // Calculate final product
            ans[i] = (int) ((x * sd) % mod);
        }
        
        return ans;
    }
}