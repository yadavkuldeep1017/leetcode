class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] countCh = new int[26];
        for(char ch:s.toCharArray()){
            countCh[ch - 'a']++;
        }
        char[] ansArray = new char[n];
        int index = 0;
        int oddCharIndex = -1;
        for(int i = 0; i < 26; i++){
            if(countCh[i] == 0){
                continue;
            }
            char ch = (char)('a' + i);
            if((countCh[i] & 1) == 1){
                oddCharIndex = i;
            }
            for(int j = 0; j < countCh[i] / 2; j++){
                ansArray[index] = ch;
                ansArray[n - index - 1] = ch;
                index++;
            }
        }
        if(oddCharIndex != -1){
            ansArray[index] = (char)('a' + oddCharIndex);
        }
        StringBuilder str = new StringBuilder();
        for(char ch: ansArray){
            str.append(ch);
        }
        return str.toString();
    }
}