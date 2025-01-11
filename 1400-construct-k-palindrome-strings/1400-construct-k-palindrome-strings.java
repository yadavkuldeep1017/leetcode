class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n == k) {
            return true;
        }
        if (k > n) {
            return false;
        }
        int[] charArray = new int[26];
        Map<Character, Integer> map = new HashMap();
        for (Character ch : s.toCharArray()) {
            int value = ch - 'a';
            charArray[value] += 1;
        }
        int countOdd = 0;
        for (int i = 0; i < 26; i++) {
            countOdd += (charArray[i] & 1) == 0 ? 0 : 1;
        }
        if (countOdd <= k) {
            return true;
        }
        return false;
    }
}