class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int ans = 0;
        int i = 0;
        int j = 0;
        int n = nums.length;
        while(j < n){
            if(map.containsKey(nums[j])){
                int value = map.get(nums[j]);
                if(value == k){
                    while(i < j && nums[i] != nums[j]){
                        int iValue = map.get(nums[i]);
                        if(iValue == 1){
                            map.remove(nums[i]);
                        }
                        else{
                            map.put(nums[i], iValue - 1);
                        }
                        i++;
                    }
                    i++;
                }
                else{
                    map.put(nums[j], value + 1);
                    ans = Math.max(ans, j - i + 1);
                }
                
            }
            else{
                map.put(nums[j], 1);
                ans = Math.max(ans, j - i + 1);
            }
            j++;
        }
        return ans;
    }
}