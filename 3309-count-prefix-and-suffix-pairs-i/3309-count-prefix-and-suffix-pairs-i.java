class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int ans=0;
        int n=words.length;
        for(int i=0;i<n-1;i++){
            int strLen=words[i].length();
            for(int j=i+1;j<n;j++){
                int jLen=words[j].length();
                if(jLen>=strLen){
                    if(words[j].startsWith(words[i]) && 
                        words[j].endsWith(words[i])){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}