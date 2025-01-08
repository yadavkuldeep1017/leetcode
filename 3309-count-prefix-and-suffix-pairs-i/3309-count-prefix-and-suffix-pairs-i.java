class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int ans=0;
        int n=words.length;
        for(int i=0;i<n-1;i++){
            int strLen=words[i].length();
            for(int j=i+1;j<n;j++){
                int jLen=words[j].length();
                if(jLen>=strLen){
                    if(words[i].equals(words[j].substring(0,strLen)) && 
                        words[i].equals(words[j].substring(jLen-strLen,jLen))){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}