class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            Map<Integer, Integer> charFreqMap = new HashMap();
            Map<Integer, Integer> freqCountMap = new HashMap();
            charFreqMap.put(nums[i], 1);
            freqCountMap.put(1, 1);
            for (int j = i + 1; j < n; j++) {
                int charFreq = charFreqMap.getOrDefault(nums[j], 0);
                int currFreqCount = freqCountMap.getOrDefault(charFreq, 0);
                if (currFreqCount == 1) {
                    freqCountMap.remove(charFreq);
                }
                else if(currFreqCount > 1){
                    freqCountMap.put(charFreq, currFreqCount - 1);
                }
                int newCharFreq = charFreq + 1;
                charFreqMap.put(nums[j], newCharFreq);
                freqCountMap.put(newCharFreq, freqCountMap.getOrDefault(newCharFreq, 0) + 1);
                int fSize = freqCountMap.size();
                if(fSize == 1 && charFreqMap.size() == 1){
                    ans = Math.max(ans, j - i + 1);
                }
                else if(fSize == 2){
                    int min = Integer.MAX_VALUE;
                    int max = Integer.MIN_VALUE;
                    for(int key: freqCountMap.keySet()){
                        min = Math.min(min, key);
                        max = Math.max(max, key);
                    }
                    // System.out.println(min +" " +max);
                    if(max == 2 * min){
                        ans = Math.max(ans, j - i + 1);
                    }
                }
                // System.out.println(i+" "+j+" "+ans);
            }
            if(ans == n - i + 1){
                return ans;
            }
        }
        return ans;
    }
}