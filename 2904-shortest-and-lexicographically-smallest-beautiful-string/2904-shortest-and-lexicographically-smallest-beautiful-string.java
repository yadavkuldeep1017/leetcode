class Solution {
    public String smallString(String a, String b){
        if(a.equals(b)){
            return a;
        }
        int n = a.length();
        for(int i = 0; i < n; i++){
            char ch1 = a.charAt(i);
            char ch2 = b.charAt(i);
            if(ch1 > ch2){
                return b;
            }
            else if(ch1 < ch2){
                return a;
            }
        }
        return a;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int i = 0;
        while(i < n && s.charAt(i) != '1'){
            i++;
        }
        int j = i;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        String ans = "";
        while(j < n){
            char ch = s.charAt(j);
            if(ch == '1'){
                if(count == k - 1){
                    int len = j - i + 1;
                    if(minLength > len){
                        minLength = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                    else if(minLength == len){
                        ans = smallString(ans, s.substring(i, j + 1));
                    }
                    if(minLength == k){
                        return ans;
                    }
                    i++;
                    while(i <= j && s.charAt(i) != '1'){
                        i++;
                    }
                }
                else{
                    count++;
                }
            }
            j++;
            // System.out.println(i + " "+j+" "+count+" "+minLength+" "+ans);
        }
        return ans;
    }
}