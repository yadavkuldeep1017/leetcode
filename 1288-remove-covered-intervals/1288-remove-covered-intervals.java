class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if(a[0] == b[0]){
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int ans = 0;
        int i = 1;
        int end = intervals[0][1];
        int n = intervals.length;
        while(i < n){
            while(i < n && end >= intervals[i][1]){
                i++;
                ans++;
            }
            if(i < n){
                end = intervals[i][1];
            }
            i++;
        }
        return n - ans;
    }
}