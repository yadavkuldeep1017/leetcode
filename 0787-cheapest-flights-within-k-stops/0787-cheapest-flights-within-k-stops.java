class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] f : flights) {
            adj.get(f[0]).add(new int[] { f[1], f[2] });
        }
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList();
        q.add(new int[] { 0, src, 0 });
        distance[src] = 0;
        while (!q.isEmpty()) {
            int[] flight = q.poll();
            if(flight[0] > k) continue;
            for (int[] pair : adj.get(flight[1])) {
                int node = pair[0];
                int dist = pair[1];
                int newDistance = dist + flight[2];
                if (distance[node] > newDistance) {
                    q.add(new int[] { flight[0] + 1, node, newDistance });
                    distance[node] = newDistance;
                }
            }

        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}