class Solution {
    public String minWindow(String s, String t) {

        // if(s.length() < t.length()){
        //     return "";
        // }

        Map<Character, Integer> countT = new HashMap();
        for(char ch: t.toCharArray()){
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }

        List<Integer> pos = new ArrayList();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(t.contains(String.valueOf(ch))){
                pos.add(i);
            }
        }

        int i = 0;
        int j = 0;
        int n = pos.size();
        int leftIndex = -1;
        int rightIndex = -1;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap();
        while(j < n){
            int index = pos.get(j);
            char ch = s.charAt(index);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(i <= j && mapEquals(map, countT)){
                int index2 = pos.get(i);
                // System.out.println(map+" "+index+" "+index2+" "+ch);
                if(minLength > index - index2 + 1){
                    minLength = index - index2 + 1;
                    leftIndex = index2;
                    rightIndex = index;
                }
                char iChar = s.charAt(index2);
                int value = map.get(iChar);
                if(value == 1){
                    map.remove(iChar);
                }
                else{
                    map.put(iChar, value - 1);
                }
                i++;
            }
            j++;
        }
        
        return leftIndex == -1 ? "" : s.substring(leftIndex, rightIndex + 1);
    }
    boolean mapEquals(Map<Character, Integer> map1, Map<Character, Integer> map2){
        for(char ch: map2.keySet()){
            if(map1.containsKey(ch)){   
                int value2 = map2.get(ch);
                int value1 = map1.get(ch);
                if(value1 < value2){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
}