class Solution {

    public boolean isPossible(List<List<int[]>> adjList, int n, int source, int target, int k, int threshold){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        q.offer(new int[]{source, 0});
        dist[source] = 0;
        while(!q.isEmpty()){
            int[] data = q.poll();
            int node = data[0];
            int weight = data[1];
            if(node == target){
                return weight <= k;
            }
            for(int[] edge: adjList.get(node)){
                int newCost = weight + (edge[1] > threshold ? 1 : 0);
                if(dist[edge[0]] > newCost){
                    dist[edge[0]] = newCost;
                    q.offer(new int[]{edge[0], newCost});
                }
            }
        }
        return false;
    }

    public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {
        List<List<int[]>> adjList = new ArrayList();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList());
        }
        int low = 0;
        int high = 0;
        for(int[] edge:edges){
            high = Math.max(high, edge[2]);
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adjList.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(adjList, n, source, target, k,mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}