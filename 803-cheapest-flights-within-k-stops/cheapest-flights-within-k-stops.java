class Solution {
    
    record Edge(int to, int cost) {}
    record State(int node, int price, int stops) {}
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int flight[] : flights) {
            int u = flight[0], v = flight[1], w = flight[2];
            adj.get(u).add(new Edge(v, w));
        }
        
        int dist[][] = new int[n][k+2];
        for (int i=0; i<n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }
        dist[src][0] = 0;
        
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.price(), b.price()));
        pq.offer(new State(src, 0, 0));
        
        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int u = curr.node(), d = curr.price(), s = curr.stops();

            if (u == dst) {
                return d;
            }

            if (s > k) {
                continue;
            }

            for (Edge nei : adj.get(u)) {
                int v = nei.to(), nd = d + nei.cost();
                if (nd < dist[v][s+1] && s <= k) {
                    dist[v][s+1] = nd;
                    pq.offer(new State(v, nd, s+1));
                }
            }
        }

        return -1;
    }
}