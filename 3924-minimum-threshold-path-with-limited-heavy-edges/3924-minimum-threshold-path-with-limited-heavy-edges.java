class Solution {

    public boolean isPossible(List<List<int[]>> adjList,
                          int n,
                          int source,
                          int target,
                          int k,
                          int threshold){

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    Deque<Integer> dq = new ArrayDeque<>();

    dq.offerFirst(source);
    dist[source] = 0;

    while(!dq.isEmpty()){

        int node = dq.pollFirst();

        for(int[] edge : adjList.get(node)){

            int next = edge[0];

            int cost = (edge[1] > threshold) ? 1 : 0;

            int newCost = dist[node] + cost;

            if(newCost < dist[next]){

                dist[next] = newCost;

                if(cost == 0){
                    dq.offerFirst(next);
                }else{
                    dq.offerLast(next);
                }
            }
        }
    }

    return dist[target] <= k;
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