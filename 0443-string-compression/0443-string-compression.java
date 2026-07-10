class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        int n = chars.length;
        int i = 0;
        int j = 0;
        while(i < n){
            int count = 1;
            while(i + 1 < n && chars[i] == chars[i + 1]){
                count ++;
                i++;
            }
            chars[j++] = chars[i];
            if(count == 1){
                ans++;
            }
            else{
                String strCount = String.valueOf(count);
                ans += strCount.length() + 1;
                for(char chCount : strCount.toCharArray()){
                    chars[j++] = chCount;
                }
            }
            i ++;
        }
        // System.out.println(ans);
        return ans;
    }
}