class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (((n & 1) == 1) || (locked.charAt(n - 1) == '1' && s.charAt(n - 1) == '(')
                || (locked.charAt(0) == '1' && s.charAt(0) == ')')) {
            return false;
        }
        Stack<Character> stack=new Stack();
        stack.add('(');
        int open=0;
        for(int i=1;i<n-1;i++){
            char str=s.charAt(i);
            if(locked.charAt(i)=='1'){
                if(str==')'){
                    if(stack.isEmpty()){
                        if(open>0){
                            stack.add('(');
                            open--;
                        }
                        else{
                            return false;
                        }
                    }else{
                        stack.pop();
                    }
                }
                else{
                    stack.add('(');
                }
            }
            else{
                if(stack.isEmpty()){
                    stack.add(')');
                }else{
                    stack.pop();
                    open++;
                }
            }
        }
        return stack.size()==1;
    }
}