class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] charArray = new int[26];
        for (char ch : text.toCharArray()) {
            charArray[ch - 'a']++;
        }
        int ans = charArray[0];//a
        ans = Math.min(ans, charArray[1]);//b        
        ans = Math.min(ans, charArray[13]);//n
        ans = Math.min(ans, charArray[11] / 2);//l
        return Math.min(ans, charArray[14] / 2);//o
    }
}