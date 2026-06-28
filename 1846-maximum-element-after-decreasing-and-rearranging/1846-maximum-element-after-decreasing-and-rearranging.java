class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int min = 1;
        int max = min + n - 1;
        int ans = min ;
        for(int i = 1; i < n; i++){
            if(ans + 1 <= arr[i]){
                ans++;
            }
        }
        return ans;        
    }
}