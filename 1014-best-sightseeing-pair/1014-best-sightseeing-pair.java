class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
        int maxSum=values[1]+values[0]-1;
        int max=Math.max(values[1],values[0]-1);
        for(int i=2;i<n;i++){
            max--;
            maxSum=Math.max(maxSum,max+values[i]);
            max=Math.max(max,values[i]);
        }
        return maxSum;
    }
}