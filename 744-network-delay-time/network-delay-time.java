class Solution {
    
    record Edge(int to, int weight) {}
    record State(int vertex, int time) {}

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int time[] : times) {
            int u = time[0], v = time[1], w = time[2];
            adj.get(u).add(new Edge(v, w));
        }

        int dist[] = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);
        dist[k] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time(), b.time()));
        pq.offer(new State(k, 0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int u = curr.vertex(), d = curr.time();

            for (Edge nei : adj.get(u)) {
                int v = nei.to(), w = nei.weight();

                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new State(v, dist[v]));
                }
            }
        }

        int ans = - (int) 1e9;

        for (int i=1; i<=n; i++) {
            ans = Math.max(ans, dist[i]);
        }

        return ans == (int) 1e9 ? -1 : ans;
    }
}