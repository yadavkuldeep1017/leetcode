class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int firstKCardsSum = 0;
        int lastKCardsSum = 0;
        for(int i = 0; i < k; i++){
            firstKCardsSum += cardPoints[i];
        }
        int maxSum = firstKCardsSum;
        if(k == cardPoints.length){
            return maxSum;
        }
        int l = k - 1;
        int r = cardPoints.length - 1;
        for(int i = r; i >= cardPoints.length - k; i--){
            lastKCardsSum += cardPoints[i];
            firstKCardsSum -= cardPoints[l--];
            maxSum = Math.max(maxSum, firstKCardsSum + lastKCardsSum);
        }
        return maxSum;
    }
}