class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] x, int[] y){
                if(x[0] == y[0]){
                    return Integer.compare(x[1], y[1]);
                }
                return Integer.compare(x[0], y[0]);
            }
        });
        List<int[]> list = new ArrayList();
        int[] newInterval = intervals[0];
        list.add(newInterval);
        for(int[] interval: intervals){
            if(newInterval[1] >= interval[0]){
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
            else{
                newInterval = interval;
                list.add(newInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}