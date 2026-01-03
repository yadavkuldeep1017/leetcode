class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int ans = 0;
        for(int i = n - 1; i >= 0; i--){
            if(ans < citations[i]){
                ans++;
            }
            else{
                return ans;
            }
        }
        return ans;
    }
}