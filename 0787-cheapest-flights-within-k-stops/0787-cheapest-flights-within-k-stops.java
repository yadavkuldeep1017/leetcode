class Solution {
    static class Pair{
        int x;
        int distance;
        Pair(int x, int distance){
            this.x = x;
            this.distance = distance;
        }
    }
    static class Flight{
        int index;
        int distance;
        int stop;
        Flight(int index, int distance, int stop){
            this.index = index;
            this.distance = distance;
            this.stop = stop;
        }
    }
    static class FlightComparator implements Comparator<Flight>{
        public int compare(Flight f1, Flight f2){
            if(f1.stop == f2.stop){
                return Integer.compare(f1.distance, f2.distance);
            }
            return Integer.compare(f1.stop, f2.stop);
        }
    }
    public List<List<Pair>> getAdjList(int[][] flights, int n){
        List<List<Pair>> adjList = new ArrayList();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList());
        }
        for(int i = 0; i < flights.length; i++){
            adjList.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        return adjList;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList = getAdjList(flights, n);
        // for(List<Pair> listpair:adjList){
        //     for(Pair pair:listpair){
        //       System.out.print(pair.x+","+pair.distance+":");              
        //     }
        //     System.out.println();
        // }
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Flight> pq = new PriorityQueue(new FlightComparator());
        pq.add(new Flight(src, 0, 0));
        distance[src] = 0;
        while(!pq.isEmpty()){
            Flight flight = pq.poll();
            for(Pair pair:adjList.get(flight.index)){
                int currDistance = pair.distance + flight.distance;
                if(currDistance < distance[pair.x]){
                    distance[pair.x] = currDistance;
                    if(k > flight.stop){
                        pq.add(new Flight(pair.x,currDistance,flight.stop+1));
                    }
                }
            }

        }
        // for(int num:distance){
        //     System.out.println(num);
        // }
        return distance[dst] == Integer.MAX_VALUE ? -1:
        distance[dst];
    }
}