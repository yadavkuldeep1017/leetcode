class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] splitStr = s.split(" ");
        if(pattern.length() != splitStr.length){
            return false;
        }
        Map<Character, String> map1 = new HashMap();
        Map<String, Character> map2 = new HashMap();
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(map1.containsKey(ch)){
                if(!map1.get(ch).equals(splitStr[i])){
                    return false;
                }
            }
            else{
                map1.put(ch, splitStr[i]);
            }
            if(map2.containsKey(splitStr[i])){
                if(ch != map2.get(splitStr[i])){
                    return false;
                }
            }
            else{
                map2.put(splitStr[i], ch);
            }  
        }
        return true;
    }
}