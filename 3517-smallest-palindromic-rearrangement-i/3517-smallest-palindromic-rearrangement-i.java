class Solution {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        char[] ans = new char[s.length()];
        int left = 0, right = s.length() - 1;
        int mid = s.length() / 2;

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);

            while (count[i] >= 2) {
                ans[left++] = ch;
                ans[right--] = ch;
                count[i] -= 2;
            }

            if (count[i] == 1) {
                ans[mid] = ch;
            }
        }

        return new String(ans);
    }
}