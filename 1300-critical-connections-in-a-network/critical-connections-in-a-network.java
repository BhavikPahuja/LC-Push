class Solution {
    int timer = 1;
    void dfs(int node, int parent, List<List<Integer>> adj, boolean vis[], int time[], int last[], List<List<Integer>> ans) {
        vis[node] = true;
        time[node] = timer;
        last[node] = timer;
        timer++;
        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                dfs(nei, node, adj, vis, time, last, ans);
                last[node] = Math.min(last[node], last[nei]);
                if (last[nei] > time[node]) {
                    ans.add(Arrays.asList(nei, node));
                }
            }
            if (nei != parent) {
                last[node] = Math.min(last[node], last[nei]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int u = connection.get(0), v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, -1, adj, new boolean[n], new int[n], new int[n], ans);
        return ans;
    }
}