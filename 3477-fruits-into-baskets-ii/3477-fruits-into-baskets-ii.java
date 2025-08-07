class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int ans = 0;
        List<Integer> list = new LinkedList();
        for(Integer basket:baskets){
            list.add(basket);
        }
        for(int i = 0 ; i<n ;i++){
            boolean isFound = false;
            for(int j = 0; j< list.size(); j++){
                if(fruits[i] <= list.get(j)){
                    list.remove(j);
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                ans++;
            }
        }
        return ans;
    }
}