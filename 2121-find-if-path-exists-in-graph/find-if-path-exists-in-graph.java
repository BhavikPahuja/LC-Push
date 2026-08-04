class Solution {

    void rec(int curr, boolean vis[], List<List<Integer>> adj) {

        vis[curr] = true;

        for (int nei : adj.get(curr)) {

            if (!vis[nei]) {

                rec(nei, vis, adj);
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for (int i=0; i<n; i++) {

            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean vis[] = new boolean[n];

        rec(source, vis, adj);

        return vis[destination];
    }
}