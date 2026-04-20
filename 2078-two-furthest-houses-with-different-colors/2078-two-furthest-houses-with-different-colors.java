class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDiff = 0;
        int color = colors[0];
        for(int i = n - 1; i > 0; i--){
            if(color != colors[i]){
                maxDiff = i;
                break;
            }
        }
        System.out.println(maxDiff);
        color = colors[n - 1];
        for(int i = 0; i < n - 1; i++){
            if(color != colors[i]){
                maxDiff = Math.max(maxDiff, n - i - 1);
                break;
            }
        }
        return maxDiff;
    }
}