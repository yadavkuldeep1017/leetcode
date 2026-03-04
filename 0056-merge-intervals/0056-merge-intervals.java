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

        int i = 0;
        List<Pair> list = new ArrayList();
        while(i < n){
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(i + 1 < n){
                end = Math.max(end, intervals[i][1]);
                if(end < intervals[i+1][0]){
                    break;
                }
                end = Math.max(end, intervals[i + 1][1]);
                i++;
                // System.out.println(end);
            }
                            // System.out.println(start+ " "+end);

            Pair<Integer, Integer> pair = new Pair(start, end);
            list.add(pair);
            i++;
        }

        int[][] ans = new int[list.size()][2];
        for(int j = 0; j < list.size(); j++){
            Pair<Integer, Integer> pair = list.get(j);
            ans[j][0] = pair.getKey();
            ans[j][1] = pair.getValue();
        }
        return ans;
    }
}