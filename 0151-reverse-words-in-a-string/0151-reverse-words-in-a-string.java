class Solution {
    public String reverseWords(String s) {
        StringBuffer ans = new StringBuffer();
        s = s.trim();
        int size = s.length();
        StringBuffer temp = new StringBuffer();
        for(int i = size - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == ' '){
                if(temp.length() > 0){
                    ans.append(temp);
                    ans.append(' ');
                    temp.delete(0, temp.length());
                }
            }
            else{
                temp.insert(0, ch);
            }
        }
        ans.append(temp);
        return ans.toString();
    }
}