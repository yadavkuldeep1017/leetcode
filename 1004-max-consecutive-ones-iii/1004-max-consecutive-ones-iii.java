class Solution {
    public int longestOnes(int[] nums, int k) {
        Queue<Integer> q = new ArrayDeque();
        int max = 0;
        int i = 0;
        int start = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                if (k == 0) {
                    start = i + 1;
                } else {
                    if (q.size() == k) {
                        start = q.poll() + 1;
                    } 
                    q.add(i);
                }
            }
            max = Math.max(max, i - start + 1);
            i++;
        }
        return max;
    }
}