class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        if (n < 3) {
            return n;
        }
        int[] charArray = new int[26];
        for (char ch : s.toCharArray()) {
            charArray[ch - 'a']++;
        }
        int totalLength = 0;
        for (int i = 0; i < 26; i++) {
            if (charArray[i] > 2) {
                charArray[i]=(charArray[i]%2)==0?2:1;
            }
            totalLength += charArray[i];
        }
        return totalLength;
    }
}