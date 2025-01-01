class Solution {
    public int maxScore(String s) {
        int ans=0;
        int totalSum=0;
        for(int i=0;i<s.length();i++){
            totalSum+=s.charAt(i)-'0';
        }
        int zerosCount=0;
        for(int i=0;i<s.length()-1;i++){
            zerosCount+=s.charAt(i)=='0'?1:0;
            totalSum-=s.charAt(i)-'0';
            ans=Math.max(ans,zerosCount+totalSum);
        }
        return ans;
    }
}