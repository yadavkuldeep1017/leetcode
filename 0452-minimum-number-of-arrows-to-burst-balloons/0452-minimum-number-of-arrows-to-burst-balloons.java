class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n == 1){
            return 1;
        }
        Arrays.sort(points, (a,b)->{
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int ans = 1;
        int max = points[0][1];

        for(int[] point:points){
            if(point[0] > max){
                ans++;
                max = point[1];
            }
            else if(point[1] < max){
                max = point[1];
            }
        }
        return ans;
    }
}