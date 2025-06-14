class Solution {
    public int minMaxDifference(int num) {
        String strNum = String.valueOf(num);
        char minReplaceNum = strNum.charAt(0);
        char maxReplaceNum = strNum.charAt(0);
        for(int i=0;i<strNum.length();i++){
            char ch = strNum.charAt(i);
            if(ch!='9'){
                maxReplaceNum = ch;
                break;
            }
        }
        for(int i=0;i<strNum.length();i++){
            char ch = strNum.charAt(i);
            if(ch!='0'){
                minReplaceNum = ch;
                break;
            }
        }
        System.out.println(maxReplaceNum+" "+minReplaceNum);
        StringBuilder maxNum = new StringBuilder();
        StringBuilder minNum = new StringBuilder();
        for(int i=0;i<strNum.length();i++){
            char ch = strNum.charAt(i);
            if(ch==maxReplaceNum){
                maxNum.append('9');
            } else{
                maxNum.append(ch);
            }
            if(ch==minReplaceNum){
                minNum.append('0');
            } else{
                minNum.append(ch);
            }
        }
        System.out.println(Integer.parseInt(maxNum.toString())+" "+Integer.parseInt(minNum.toString()));
        return Integer.parseInt(maxNum.toString())-Integer.parseInt(minNum.toString());
    }
}