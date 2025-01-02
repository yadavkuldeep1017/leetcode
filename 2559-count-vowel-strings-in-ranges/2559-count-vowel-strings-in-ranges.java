class Solution {

    public boolean isVowelStartEnd(String word){
        char first=word.charAt(0);
        char last=word.charAt(word.length()-1);
        Map<Character,Integer> map=new HashMap();
        map.put('a',0);map.put('e',0);map.put('i',0);map.put('o',0);map.put('u',0);
        if(map.containsKey(first) && map.containsKey(last)){
            return true;
        }
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=queries.length;
        int wordLen=words.length;
        int[] ans=new int[n];
        int[] prefixSum=new int[wordLen+1];
        prefixSum[0]=0;
        for(int i=1;i<=wordLen;i++){
            prefixSum[i]=prefixSum[i-1];
            if(isVowelStartEnd(words[i-1])){
                prefixSum[i]+=1;
            }
            // System.out.println(prefixSum[i]);
        }
        for(int i=0;i<n;i++){
            int start=queries[i][0];
            int last=queries[i][1];
            ans[i]=prefixSum[last+1]-prefixSum[start];
        }
        return ans;
    }
}