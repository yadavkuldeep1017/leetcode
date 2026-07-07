class Solution {
    public long sumAndMultiply(int n) {
        long num = 0;
        long digitSum = 0;
        int mult = 1;
        while(n > 0){
            int digit = n % 10;
            digitSum += digit;
            if(digit != 0){
                num = digit * mult + num;
                mult *= 10;
            }
            n = n / 10;
        }
        return num * digitSum;
    }
}