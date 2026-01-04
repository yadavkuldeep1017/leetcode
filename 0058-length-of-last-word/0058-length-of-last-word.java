class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        s = s.trim();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                ans = 0;
            }
            else{
                ans++;
            }
        }
        return ans;
    }
}