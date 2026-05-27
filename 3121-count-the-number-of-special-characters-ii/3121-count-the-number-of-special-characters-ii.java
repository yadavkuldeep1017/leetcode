class Solution {
    public int numberOfSpecialChars(String word) {
        /*
            -1 - Not possible
            0  - Not visited
            1  - Small Visited
            2 -  Processed
        */
        int[] small = new int[26];
        int[] upper = new int[26];
        int ans = 0;
        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch)){
                int index = ch - 'A';
                if(upper[index] == -1 || upper[index] == 2){
                    continue;
                }
                if(small[index] == 0){
                    upper[index] = -1;
                    small[index] = -1;
                }
                else{
                    ans++;
                    small[index] = 2;
                    upper[index] = 2;
                }
            }
            else{
                int index = ch - 'a';
                if(small[index] == 2){
                    ans--;
                    small[index] = -1;
                }
                else if(small[index] == 0) {
                    small[index] = 1;             
                }
            }
        }
        return ans;
    }
}