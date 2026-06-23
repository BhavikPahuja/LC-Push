class Solution {

    record Edge(int to, int weight) {}
    record State(int vertex, long time) {}

    public int countPaths(int n, int[][] roads) {
        int MOD = (int) 1e9 + 7;

        List<List<Edge>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }    
        for (int road[] : roads) {
            int u = road[0], v = road[1], w = road[2];
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w));
        }

        long dist[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int ways[] = new int[n];
        ways[0] = 1;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time(), b.time()));
        pq.offer(new State(0, 0));

        while(!pq.isEmpty()) {
            State curr = pq.poll();
            int u = curr.vertex();
            long d = curr.time();
            
            for (Edge nei : adj.get(u)) {
                int v = nei.to(), w = nei.weight();

                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new State(v, dist[v]));
                    ways[v] = ways[u];
                } else if (d + w == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n-1] % MOD;
    }
}