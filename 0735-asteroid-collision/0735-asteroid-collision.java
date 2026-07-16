class Solution {

    public boolean isSame(int a, int b){
        return  (a < 0) || (a >= 0 && b>= 0) || (a < 0 && b < 0);
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        int n = asteroids.length;
        for(int i = 0; i < n; i++){
            if(!stack.isEmpty()){
                boolean isBreak = false;
                while(!stack.isEmpty()){
                    int peek = stack.peek();
                    if(isSame(peek, asteroids[i])){
                        stack.push(asteroids[i]);
                        isBreak = true;
                        break;
                    }     
                    if(peek + asteroids[i] == 0){
                        stack.pop();
                        isBreak = true;
                        break;
                    }
                    if(Math.abs(peek) > Math.abs(asteroids[i])){
                        isBreak = true;
                        break;
                    }  
                    stack.pop();
                }
                if(!isBreak){
                    stack.push(asteroids[i]);
                }
            }
            else{
                stack.push(asteroids[i]);
            }
            // System.out.println(stack);
        }
        int sz = stack.size();
        int[] ans = new int[sz];
        int i = sz - 1;
        while(!stack.isEmpty()){
            ans[i--] = stack.pop();
        }
        return ans;
    }
}