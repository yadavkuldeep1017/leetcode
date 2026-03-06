class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 1){
            return false;
        }
        Set<Integer> set = new HashSet();
        int i = 0;
        while(i < nums.length){
            int kIndex = i - k;
            if(!set.add(nums[i])){
                return true;
            }
            if(kIndex >= 0){
                set.remove(nums[kIndex]);
            }
            i++;
        }
        return false;
        
    }
}