class Solution {
    static class Pair {
        int node;
        long time;
        Pair(int node, long time){
            this.node = node;
            this.time = time;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int mod = 1_000_000_007;

        // Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] r : roads){
            adj.get(r[0]).add(new Pair(r[1], r[2]));
            adj.get(r[1]).add(new Pair(r[0], r[2]));
        }

        // Dijkstra arrays
        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.time, b.time));
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if(curr.time > dist[curr.node]) continue; // IMPORTANT optimization

            for(Pair next : adj.get(curr.node)){
                long newDist = curr.time + next.time;

                // Found shorter route
                if(newDist < dist[next.node]){
                    dist[next.node] = newDist;
                    ways[next.node] = ways[curr.node];
                    pq.add(new Pair(next.node, newDist));
                }
                // Found another shortest route
                else if(newDist == dist[next.node]){
                    ways[next.node] = (ways[next.node] + ways[curr.node]) % mod;
                }
            }
        }

        return ways[n-1];
    }
}
