class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] diff = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        if (sum < 0) {
            return -1;
        }
        int currSum = 0;
        int expectedIndex = 0;
        for (int i = 0; i < n; i++) {
            currSum += diff[i];
            if (currSum < 0) {
                expectedIndex = i + 1;
                currSum = 0;
            }
        }
        return expectedIndex;
    }
}