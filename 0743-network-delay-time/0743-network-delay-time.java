class Solution {

    public List<List<Pair<Integer, Integer>>> getAdjList(int[][] times, int n){
        List<List<Pair<Integer, Integer>>> adjList = new ArrayList();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList());
        }
        for(int i = 0; i < times.length; i++){
            adjList.get(times[i][0] - 1).add(new Pair(times[i][1] - 1, times[i][2]));
        }
        return adjList;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair<Integer, Integer>>> adjList = getAdjList(times, n);
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        // System.out.println(adjList);
        Queue<Integer> q = new ArrayDeque();
        q.add(k - 1);
        visited[k - 1] = 0;
        int ans = 0;
        while(!q.isEmpty()){
            int num = q.poll();
            List<Pair<Integer,Integer>> list = adjList.get(num);
            for(Pair<Integer, Integer> pair: list){
                int key = pair.getKey();
                int value = pair.getValue();
                if(visited[key] == Integer.MAX_VALUE){
                    visited[key] = Math.min(visited[key],visited[num] + value);
                    q.add(key);
                }
                else if(visited[key] > visited[num] + value){
                    visited[key] = visited[num] + value;
                    q.add(key);
                }
                
            }
        }
        for(int i = 0; i < n; i++){
            if(visited[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, visited[i]);
        }
        return ans;
    }
}