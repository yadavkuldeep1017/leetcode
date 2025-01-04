class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        Map<Character,Integer> map=new HashMap();
        Map<Character,Integer> firstIdxMap=new HashMap();
        Map<Character,Integer> lastIdxMap=new HashMap();
        int ans=0;
        int[] unqChar=new int[n];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
                lastIdxMap.put(ch,i);
            }
            else{
                map.put(ch,1);
                firstIdxMap.put(ch,i);
                lastIdxMap.put(ch,i);                
            }
           unqChar[i]=map.size();
        }
        for(Character ch:map.keySet()){
            int value=map.get(ch);
            int firstIndex=firstIdxMap.get(ch);
            int lastIndex=lastIdxMap.get(ch);
            if(value>1 && firstIndex+1<lastIndex){
                Set<Character> unqSet=new HashSet();
                for(int i=firstIndex+1;i<lastIndex;i++){
                    unqSet.add(s.charAt(i));
                }
                ans=ans+unqSet.size();
                // System.out.println(ch+" "+ans+" "+unqChar[lastIndex]+" "+unqChar[firstIndex]+" "+value);
            }
        }
        return ans;
    }
}