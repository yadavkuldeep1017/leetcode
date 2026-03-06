class Solution {
    public int sumSquare(int n){
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
            sum += rem * rem;
            n = n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while(set.add(n)){
            if(n == 1){
                return true;
            }
            n = sumSquare(n);
        }
        return false;
    }
}