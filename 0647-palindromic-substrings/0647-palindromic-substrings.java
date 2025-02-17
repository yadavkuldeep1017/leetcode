class Solution {
    public boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    public int countSubstrings(String s) {
        int answer=0;
        int size=s.length();
        for(int i=0;i<size;i++){
            answer+=1;
            for(int j=i+1;j<size;j++){
                if(isPalindrome(s.substring(i,j+1))){
                    answer++;
                }
            }
        }
        return answer;
    }
}