class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet();
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }
        int n = nums.length;
        List<Integer> ans = new ArrayList();
        if(max - min + 1 == n){
            return ans;
        }
        for(int i = min; i <= max; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}