class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int i = 0;
        int j = 1;
        while(j < n){
            if(height[j] > height[i]){
                maxArea = Math.max(maxArea, (j - i) * height[i]);
                i = j;
            }
            else{
                maxArea = Math.max(maxArea, (j - i) * height[j]);
            }
            j++;
        }
        return maxArea;
    }
}