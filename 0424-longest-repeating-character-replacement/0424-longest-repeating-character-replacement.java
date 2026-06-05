class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 1;
        int[] count = new int[26];
        char[] ch = s.toCharArray();
        int n = ch.length;
        int l = 0;
        int r = 0;
        int maxSame = 0;
        while(l < n && r < n){
            maxSame = Math.max(maxSame, ++count[ch[r] - 'A']);
            while((r - l + 1) - maxSame > k){
                count[ch[l] - 'A']--;
                maxSame = 0;
                for(int i = 0; i < 26; i++){
                    maxSame = Math.max(maxSame, count[i]);
                }
                l++;
            }
            ans = Math.max(ans, (r - l + 1));
            r++;
        }
        return ans;
    }
}