class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch == '#'){
                result.append(result);
            }
            else if(ch == '%'){
                result.reverse();
            }
            else if(ch == '*'){
                int len = result.length();
                if(len > 0){
                    result.delete(len - 1, len);
                }
            }
            else{
                result.append(ch);
            }
        }
        return result.toString();
    }
}