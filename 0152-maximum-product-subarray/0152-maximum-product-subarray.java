class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int prefixProd = 1;
        int suffixProd = 1;
        for(int i = 0; i < nums.length; i++){
            prefixProd = prefixProd * nums[i];
            suffixProd = suffixProd * nums[nums.length - 1 - i];
            maxProduct = Math.max(prefixProd, maxProduct);
            maxProduct = Math.max(suffixProd, maxProduct);
            if(suffixProd == 0){
                suffixProd = 1;
            }
            if(prefixProd == 0){
                prefixProd = 1;
            }
        }
        return maxProduct;
    }
}