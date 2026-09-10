class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> countT = new HashMap();
        for(char ch: t.toCharArray()){
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }

        int sLen = s.length();
        int tLen = t.length();

        int i = 0;
        int j = 0;
        int leftIndex = -1;
        int rightIndex = -1;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap();
        while(j < sLen){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(i <= j && mapEquals(map, countT)){
                if(minLength > j - i + 1){
                    minLength = j - i + 1;
                    leftIndex = i;
                    rightIndex = j;
                }
                if(minLength == tLen){
                    return s.substring(leftIndex, rightIndex + 1);
                }
                char iChar = s.charAt(i);
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