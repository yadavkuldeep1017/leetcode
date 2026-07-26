class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int total1 = 0;
        char[] arr = s.toCharArray();
        for(char ch: arr){
            total1 += ch - '0';
        }
        int ans = total1;
        int prev0 = 0;
        int i = s.indexOf('0');
        while(i >= 0 && i < n){
            int startIndex = i;
            while(i < n && arr[i] != '1'){
                i++;
            }
            int countOne = 0;
            while(i < n && arr[i] != '0'){
                countOne++;
                i++;
            }
            int tempPrev0 = 0;
            while(i < n && arr[i] != '1'){
                tempPrev0++;
                i++;
            }
            if(countOne > 0 && tempPrev0 > 0){
                ans = Math.max(ans, i - startIndex - countOne + total1 + prev0);
                prev0 = tempPrev0;
            }
        }
        return ans;
    }
}