class Solution {
    public String[] divideString(String s, int k, char fill) {
        int sLength = s.length();
        int ansLength = sLength%k == 0?sLength/k:sLength/k+1;
        String[] ans = new String[ansLength];
        int index = 0;
        for(int i = 0; i<ansLength; i++){
            if(index+k > sLength){
                int diff = index+k - sLength;
                String fillCharRepeat = String.valueOf(fill).repeat(diff);
                ans[i] = s.substring(index, sLength) + fillCharRepeat;
            }
            else{
                ans[i] = s.substring(index, index+k);
                index += k; 
            }
        }
        return ans;
    }
}