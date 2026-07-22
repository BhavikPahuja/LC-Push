class Solution {
    
    record Edge(int to, double weight) {}
    record State(int node, double pro) {}

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        List<List<Edge>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {

            adj.add(new ArrayList<>());
        }
        for (int i=0; i<edges.length; i++) {

            int edge[] = edges[i];

            int u = edge[0], v = edge[1];
            double w = succProb[i];
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w));
        }

        double max_pro[] = new double[n];

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Double.compare(b.pro(), a.pro()));
        pq.offer(new State(start_node, 1));
        max_pro[start_node] = 1;

        double ans = 0;

        while (!pq.isEmpty()) {

            State curr = pq.poll();
            int u = curr.node();
            double d = curr.pro();
            max_pro[u] = d;

            if (u == end_node) {

                ans = Math.max(ans, d);
            }

            for (Edge nei : adj.get(u)) {

                int v = nei.to();
                double w = nei.weight();

                if (max_pro[v] < d * w) {

                    pq.offer(new State(v, d * w));
                }
            }
        }

        return ans;
    }
}