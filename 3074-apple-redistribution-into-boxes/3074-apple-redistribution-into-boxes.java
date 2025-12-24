class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = Arrays.stream(apple) // Creates an IntStream
                .boxed() // Boxes int primitives to Integer objects
                .reduce(0, (a, b)-> a + b);
        Arrays.sort(capacity);
        int ans = 0;
        for(int i = capacity.length - 1; i >= 0; i--){
            ans++;
            sum -= capacity[i];
            if(sum < 1){
                return ans;
            }
        }

        return apple.length;
    }
}