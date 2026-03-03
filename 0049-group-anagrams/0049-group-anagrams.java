class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(String s:strs){
            int[] count = new int[26];
            Arrays.fill(count, 0);
            for(char ch:s.toCharArray()){
                count[ch - 'a']++;
            }
            StringBuilder strBuilder = new StringBuilder();
            for(int i = 0; i < 26; i++){
                strBuilder.append(count[i]+"#");
            }
            if(map.containsKey(strBuilder.toString())){
                map.get(strBuilder.toString()).add(s);
            }
            else{
                List<String> list = new ArrayList();
                list.add(s);
                map.put(strBuilder.toString(), list);
            }
            
        }        
        return new ArrayList(map.values());

    }
}