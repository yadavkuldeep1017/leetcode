class Solution {
    public int maxProduct(int n) {
        int firstMax = 0;
        int secondMax = 0;
        while(n > 0){
            int rem = n % 10;
            if(firstMax >= rem){
                secondMax = Math.max(secondMax, rem);
            }
            else{
                secondMax = firstMax;
                firstMax = rem;
            }
            n = n / 10;
        }
        return firstMax * secondMax;
    }
}