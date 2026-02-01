class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        Queue<Character> q = new ArrayDeque();
        char[] chArray = s.toCharArray();
        for(int i = 0; i < chArray.length; i++){
            if(!q.contains(chArray[i])){
                q.add(chArray[i]);
                maxLength = Math.max(maxLength, i - start + 1);
            }
            else{
                while(!q.isEmpty()){
                    char ch = q.peek();
                    q.remove();
                    start++;
                    if(ch == chArray[i]){
                        q.add(chArray[i]);
                        break;
                    }                    
                }
            }

        }   
        return maxLength;
    }
}