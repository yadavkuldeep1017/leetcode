class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = 1 ;
        for(int i = 1; i < n; i++){
            if(ans + 1 <= arr[i]){
                ans++;
            }
        }
        return ans;        
    }
}