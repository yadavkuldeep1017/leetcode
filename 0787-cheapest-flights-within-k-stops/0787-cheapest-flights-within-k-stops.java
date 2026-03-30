class Solution {

    public List<List<Pair<Integer,Integer>>> getAdjList(int n, int[][] flights){
        List<List<Pair<Integer,Integer>>> adjList = new ArrayList();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList());
        }
        for(int i = 0; i < flights.length; i++){
            adjList.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        return adjList;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair<Integer,Integer>>> adjList = getAdjList(n, flights);
        // System.out.println(adjList);
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[0], b[0]);
        });
        q.add(new int[]{0, src, 0});
        distance[src] = 0;
        while(!q.isEmpty()){
            int[] flight = q.poll();
            if(flight[0] <= k){
                for(Pair<Integer, Integer> pair: adjList.get(flight[1])){
                    int node = pair.getKey();
                    int dist = pair.getValue();
                    int newDistance = dist + flight[2];
                    if(distance[node] > newDistance){    
                        q.add(new int[]{flight[0] + 1, node, newDistance});
                        distance[node] = newDistance;
                    }
                }
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}