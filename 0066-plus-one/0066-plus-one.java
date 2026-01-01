class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n - 1] == 9){
            int carry = 1;
            List<Integer> list = new ArrayList();
            for(int i = n-1; i >= 0; i--){
                int sum = digits[i] + carry;
                list.add(sum%10);
                carry = sum/10;
            }
            if(carry == 1){
                list.add(1);
            }
            int listSize = list.size();
            int[] ans = new int[listSize];
            for(int i = 0; i < listSize; i++){
                ans[i] = list.get(listSize - 1 - i);
            }
            return ans;
        }
        digits[n - 1] = digits[n - 1] + 1;
        return digits;
    }
}