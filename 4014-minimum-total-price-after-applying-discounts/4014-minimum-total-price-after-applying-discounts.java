class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(discounts);
        Arrays.sort(prices);
        double ans = 0;
        int pLen = prices.length;
        int dLen = discounts.length;
        int i = pLen - 1;
        int j = dLen - 1;
        while(i >= 0 && j >= 0){
            ans += ((double)prices[i]*(100 - (double)discounts[j]))/100;
            i--;
            j--;
        }
        while(i >= 0){
            ans += (double)prices[i];
            i--;
        }
        return ans;
    }
}