import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int a : asteroids) {
            boolean alive = true;

            while (alive && !stack.isEmpty() && stack.peekLast() > 0 && a < 0) {
                int top = stack.peekLast();

                if (top < -a) {
                    stack.pollLast();      // top explodes, keep checking
                } else if (top == -a) {
                    stack.pollLast();      // both explode
                    alive = false;
                } else {
                    alive = false;         // current asteroid explodes
                }
            }

            if (alive) {
                stack.addLast(a);
            }
        }

        int[] ans = new int[stack.size()];
        int i = 0;
        for (int x : stack) {
            ans[i++] = x;
        }
        return ans;
    }
}