class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        ans.append(strs[0]);
        for(int i = 1; i < strs.length; i++){
            String a = strs[i];
            int j;
            for(j = 0; j < Math.min(a.length(), ans.length()); j++){
                if(a.charAt(j) != ans.charAt(j)){
                    break;
                }
            }
            ans.delete(j, ans.length());
        }
        return ans.toString();
    }
}