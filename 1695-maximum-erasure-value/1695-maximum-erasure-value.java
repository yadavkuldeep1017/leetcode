class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxSum = nums[0];
        int n = nums.length;
        int[] prefixSum = new int[n];
        Map<Integer, Integer> map = new HashMap();
        prefixSum[0] = nums[0];
        int prevIndex = 0;
        int currentSum = nums[0];
        map.put( nums[0], 0);
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
            if(map.containsKey(nums[i]) &&
            map.get(nums[i]) >= prevIndex ){
                prevIndex = map.get(nums[i]);
                currentSum = prefixSum[i] - prefixSum[prevIndex];
            }
            else{
                currentSum += nums[i];
            }
            maxSum = Math.max(maxSum,currentSum);
            map.put(nums[i] , i);
        }
        return maxSum;
    }
}