class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder ans = new StringBuilder(s);
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (!Character.isLetter(ans.charAt(start))) {
				start++;
			} else if (!Character.isLetterOrDigit(ans.charAt(end))) {
				end--;
			} else {
				char temp=ans.charAt(start);
				ans.setCharAt(start, ans.charAt(end));
				ans.setCharAt(end, temp);
				start++;
				end--;
			}
		}
		return ans.toString();
    }
}