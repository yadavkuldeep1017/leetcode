class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum  == 0){
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    if(!ans.contains(list)){
                        ans.add(list);
                    }
                }
                if(sum > 0){
                    k--;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    j++;
                    k--;
                }
            }
        }
       
        return ans;
    }
}