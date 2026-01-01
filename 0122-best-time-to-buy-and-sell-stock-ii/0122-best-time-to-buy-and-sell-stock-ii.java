class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        int diffMax = 0;
        int maxStock = 0;
        for(int i = 1; i < prices.length; i++){
            if(min > prices[i]){
                min = prices[i];
                max = 0;
                maxStock += diffMax;
                diffMax = 0;
            }
            else{
                if(max < prices[i]){
                    max = prices[i];
                    diffMax = Math.max(diffMax , max - min);
                }
                else{
                    min = prices[i];
                    max = 0;
                    maxStock += diffMax;
                    diffMax = 0;

                }
            }
        }
        return maxStock + diffMax;
    }
}