class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int firstKCardsSum = 0;
        int n = cardPoints.length;
        for(int i = 0; i < k; i++){
            firstKCardsSum += cardPoints[i];
        }
        int maxSum = firstKCardsSum;
        if(k == n){
            return maxSum;
        }
        int lastKCardsSum = 0;
        int l = k - 1;
        int r = n - 1;
        for(int i = r; i >= n - k; i--){
            lastKCardsSum += cardPoints[i];
            firstKCardsSum -= cardPoints[l--];
            maxSum = Math.max(maxSum, firstKCardsSum + lastKCardsSum);
        }
        return maxSum;
    }
}