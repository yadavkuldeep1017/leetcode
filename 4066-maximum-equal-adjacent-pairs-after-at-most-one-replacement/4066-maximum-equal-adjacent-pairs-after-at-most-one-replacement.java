class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int equalPairs = 0;
        int maxGain = 0;

        Map<Pair<Integer, Integer>, Integer> pairCount = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];

            if (a == b) {
                equalPairs++;
            } else {
                int small = Math.min(a, b);
                int large = Math.max(a, b);
                Pair pair = new Pair(small, large);

                int count = pairCount.getOrDefault(pair, 0) + 1;
                pairCount.put(pair, count);

                maxGain = Math.max(maxGain, count);
            }
        }

        return equalPairs + maxGain;
    }
}