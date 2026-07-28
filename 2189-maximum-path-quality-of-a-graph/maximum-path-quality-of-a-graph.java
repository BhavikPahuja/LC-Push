class Solution {

    record Edge(int to, int weight) {}
    record State(int node, int cost) {}

    int ans = 0;

    void dijkstra(int[] dist, List<List<Edge>> adj) {

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost(), b.cost()));

        dist[0] = 0;
        pq.offer(new State(0, 0));

        while (!pq.isEmpty()) {

            State curr = pq.poll();

            int u = curr.node(), d = curr.cost();

            if (d > dist[u]) {
                
                continue;
            } 

            for (Edge e : adj.get(u)) {

                int v = e.to(), w = e.weight();

                if (d + w < dist[v]) {
                    
                    dist[v] = d + w;
                    pq.offer(new State(v, dist[v]));
                }
            }
        }
    }

    void dfs(int node, int remainingTime, int currValue, int[] visit, int[] dist, int[] values, List<List<Edge>> adj) {

        if (node == 0) {

            ans = Math.max(ans, currValue);
        }

        for (Edge e : adj.get(node)) {

            int next = e.to(), time = e.weight();

            if (remainingTime < time) {

                continue;
            }

            if (remainingTime - time < dist[next]) {

                continue;
            }

            boolean firstVisit = visit[next] == 0;
            visit[next]++;

            dfs(next, remainingTime - time, currValue + (firstVisit ? values[next] : 0), visit, dist, values, adj);
            visit[next]--;
        }
    }

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {

        int n = values.length;

        List<List<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int t = edge[2];

            adj.get(u).add(new Edge(v, t));
            adj.get(v).add(new Edge(u, t));
        }

        int[] dist = new int[n];
        dijkstra(dist, adj);

        int[] visit = new int[n];
        visit[0] = 1;

        dfs(0, maxTime, values[0], visit, dist, values, adj);

        return ans;
    }
}