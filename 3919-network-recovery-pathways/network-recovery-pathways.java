import java.util.*;

class Solution {

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    List<List<Edge>> graph;
    boolean[] online;
    long k;
    int n;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        this.online = online;
        this.k = k;
        this.n = online.length;

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int low = Integer.MAX_VALUE;
        int high = 0;

        for (int[] e : edges) {
            graph.get(e[0]).add(new Edge(e[1], e[2]));
            low = Math.min(low, e[2]);
            high = Math.max(high, e[2]);
        }

        if (edges.length == 0)
            return -1;

        if (!check(low))
            return -1;

        int ans = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int limit) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();
            int u = (int) cur[0];
            long d = cur[1];

            if (d != dist[u])
                continue;

            if (u == n - 1)
                return d <= k;

            for (Edge e : graph.get(u)) {

                if (e.cost < limit)
                    continue;

                int v = e.to;

                if (v != n - 1 && !online[v])
                    continue;

                long nd = d + e.cost;

                if (nd < dist[v] && nd <= k) {
                    dist[v] = nd;
                    pq.offer(new long[]{v, nd});
                }
            }
        }

        return false;
    }
}