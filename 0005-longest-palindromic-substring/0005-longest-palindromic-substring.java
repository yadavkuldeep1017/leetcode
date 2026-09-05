class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int leftIndex = 0;
        int rightIndex = 0;
        int maxLength = 0;
        for(int i = 0; i < n; i++){
            int left = i;
            int right = i + 1;
            // for even length
            while(left >= 0 && right < n){
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                int len = (i - left) + (right - i);
                if(maxLength < len){
                    leftIndex = left;
                    rightIndex = right;
                    maxLength = len;
                }
                left--;
                right++;
            }
            left = i - 1;
            right = i + 1;
            //for odd length
            while(left >= 0 && right < n){
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                int len = (i - left) + (right - i);
                if(maxLength < len){
                    leftIndex = left;
                    rightIndex = right;
                    maxLength = len;
                }
                left--;
                right++;
            }
        }
        return s.substring(leftIndex, rightIndex + 1);
    }
}