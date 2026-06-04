class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        char[] ch = s.toCharArray();
        int n = ch.length;
        int l = 0;
        int r = 0;
        int[] count = new int[3];
        while(l < n - 2 && r < n){
            int index = ch[r] - 'a';
            count[index]++;
            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                ans += n - r;
                count[ch[l] - 'a']--;
                l++;
            }
            // System.out.println(l + " "+ r+ " "+ ans);

            r++;
        }
        return ans;
    }
}