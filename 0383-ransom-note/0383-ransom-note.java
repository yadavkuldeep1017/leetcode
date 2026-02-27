class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chArray = new int[26];
        Arrays.fill(chArray, 0);
        for(char ch : ransomNote.toCharArray()){
            chArray[ch - 'a']++;
        }
        for(char ch : magazine.toCharArray()){
            chArray[ch - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(chArray[i] > 0){
                return false;
            }
        }
        return true;
        
    }
}