class Solution {

    int[][] dp;

    public int numWays(String[] words, String target) {
        int tarLen=target.length();
        int n=words.length;
        int strLen=words[0].length();
        int mod=(int)1e9+7;
        Map<Integer,Map<Character,Integer>> map=new HashMap();
        for(int i=0;i<strLen;i++){
            Map<Character,Integer> charMap=new HashMap();
            for(int j=0;j<n;j++){
                char ch=words[j].charAt(i);
                charMap.put(ch,charMap.getOrDefault(ch,0)+1);
            }
            map.put(i,charMap);
        }
        dp=new int[tarLen+1][strLen+1];
        for(int i=0;i<=strLen;i++){
            dp[0][i]=1;
        }
        for(int i=0;i<tarLen;i++){
            char ch=target.charAt(i);
            for(int j=i;j<strLen;j++){
                Map<Character,Integer> charMap=map.get(j);
                int charValue = charMap.getOrDefault(ch, 0) % mod;
                int dpValue = dp[i][j] % mod;
                int totalChar = (int)(((long)charValue * dpValue) % mod);
                dp[i+1][j+1]=(int)(((long)(dp[i+1][j]%mod+totalChar))%mod);
            }
        }
        // for(int i=0;i<=tarLen;i++){
        //     for(int j=0;j<=strLen;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return dp[tarLen][strLen];
    }
}