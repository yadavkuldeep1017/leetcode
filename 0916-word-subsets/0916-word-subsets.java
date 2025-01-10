class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList();
        int n = words1.length;
        int m = words2.length;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < m; i++) {
            Map<Character, Integer> tempMap = new HashMap();
            for (int j = 0; j < words2[i].length(); j++) {
                char ch = words2[i].charAt(j);
                tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
            }
            for (Character key : tempMap.keySet()) {
                if (map.containsKey(key)) {
                    map.put(key, Math.max(map.get(key), tempMap.get(key)));
                } else {
                    map.put(key, tempMap.get(key));
                }
            }
        }
        StringBuilder searchString = new StringBuilder();
        for (Character key : map.keySet()) {
            searchString.append(String.valueOf(key).repeat(map.get(key)));
        }
        // System.out.println(searchString.toString());
        String finalString = searchString.toString();
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> tempMap = new HashMap();
            for (int j = 0; j < words1[i].length(); j++) {
                char ch = words1[i].charAt(j);
                tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
            }
            // System.out.println(tempMap);
            boolean isSubset=true;
            for (Character key : map.keySet()) {
                if (!tempMap.containsKey(key) || tempMap.get(key)<map.get(key)) {
                    isSubset=false;
                    break;
                } 
            }
            if(isSubset){
                ans.add(words1[i]);
            }
        }
        return ans;
    }
}