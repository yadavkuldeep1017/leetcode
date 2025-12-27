class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        List<Integer> m0 = new ArrayList();
        List<Integer> m1 = new ArrayList();
        List<Integer> m2 = new ArrayList();

        for(int i = 0; i < n; i++){
           if(nums[i] % 3 == 0){
                m0.add(nums[i]);
           }
           else if (nums[i] % 3 == 1){
                m1.add(nums[i]);
           }
           else{
                m2.add(nums[i]);
           }
        }
        Collections.sort(m0, Comparator.reverseOrder());
        Collections.sort(m1, Comparator.reverseOrder());
        Collections.sort(m2, Comparator.reverseOrder());
        int ans = 0;
        if(m0.size() > 2){
            ans = Math.max(ans, m0.get(0) + m0.get(1) + m0.get(2)); 
        }
        if(m1.size() > 2){
            ans = Math.max(ans, m1.get(0) + m1.get(1) + m1.get(2)); 
        }
        if(m2.size() > 2){
            ans = Math.max(ans, m2.get(0) + m2.get(1) + m2.get(2)); 
        }
        if(m0.size() > 0 && m1.size() > 0 && m2.size() > 0){
            ans = Math.max(ans, m0.get(0) + m1.get(0) + m2.get(0));
        }
        
        return ans;
    }
}