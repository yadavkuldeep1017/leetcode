class Solution {
    Map<Integer, String> map = new HashMap();
    public List<String> letterComb(String digits, int index){
        List<String> ans = new ArrayList();
        if(index == digits.length()){
            return ans;
        }
        int startIndex = digits.charAt(index) - '0';
        String str = map.get(startIndex);
        for(char ch : str.toCharArray()){
            List<String> list = letterComb(digits, index + 1);
            String chStr = String.valueOf(ch);
            if(list.size() == 0){
                ans.add(chStr);
            }
            for(String s:list){
                StringBuilder strBuilder = new StringBuilder(chStr);
                strBuilder.append(s);
                ans.add(strBuilder.toString());
            }
        }
        return ans;
    }
    public List<String> letterCombinations(String digits) {
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");       
        return letterComb(digits, 0);
    }
}